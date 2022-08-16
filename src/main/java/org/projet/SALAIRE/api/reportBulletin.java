package org.projet.SALAIRE.api;

import com.github.royken.converter.FrenchNumberToWords;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.projet.SALAIRE.dao.*;
import org.projet.SALAIRE.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/etat")

public class reportBulletin {
    @Autowired
    BulletinSalaireRepository bulletinSalaireRepository;
    @Autowired
    AnneeRepository anneeRepository;
    @Autowired
    MoisRepository moisRepository;
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    PrimeGlobaleRepository primeGlobaleRepository;
    @Autowired
    GrilleSalarialeRepository grilleSalarialeRepository;
    @Autowired
    GrilleFiscaleRepository grilleFiscaleRepository;
    @Autowired
    RecapSalaireRepository recapSalaireRepository;

    public reportBulletin() throws FileNotFoundException, JRException {
    }
    @GetMapping(path="/Imprimer/{id}")
    public void reportBulletin(HttpServletResponse response, @PathVariable("id") Long id) throws JRException, IOException {
        System.out.println("*************Etat**********");
        response.setContentType("text/html");
        BulletinSalaire bulletinSalaire = bulletinSalaireRepository.findById(id).get();
        Annee annee = anneeRepository.getAnneeTrue();
        Mois mois = moisRepository.getMoisTrue();


        double sommeSalaireBase = 0;
        double salaireBase = 0;
        double sommePrimeG = 0;
        double sommePrimeI = 0;
        double sommeFixe = 0;
        double irpp = 0;
        double taux = 0;
        double valVps = 0;
        double valIpts = 0;
        double salaireBrut = 0;
        double salaireNet = 0;
        double cnssEmp = 0;
        double cnssPatr = 0;
        String montantRetour = "";


        List<Contrat> LContrat = contratRepository.findContratTraiter(bulletinSalaire);
        List<GrilleFiscale> LGrilleF = grilleFiscaleRepository.findAll();

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(null);
        Vector collection = new Vector();

        for (Contrat contrat : LContrat) {
            System.out.println("Nom agent**************"+contrat.getAgent().getNomAgent()+ contrat.getEchelon().getCategorie().getLibelleCateg());
            irpp = grilleSalarialeRepository.sommeTaxeFixe(bulletinSalaire, contrat);
            sommePrimeI = grilleSalarialeRepository.sommePrimeI(bulletinSalaire, contrat);
            sommePrimeG = grilleSalarialeRepository.sommePrimeG(bulletinSalaire, contrat);
            sommeSalaireBase = grilleSalarialeRepository.sommeSalaireBase(bulletinSalaire, contrat);
            salaireBrut = (sommePrimeG + sommePrimeI + sommeSalaireBase);

            List<PrimeGlobale> LPrimeG = grilleSalarialeRepository.findPrimeGByContratSalaireBase(contrat.getIdContrat(), bulletinSalaire.getIdBulletin());
            System.out.println("DEBUT base Taille " + LPrimeG.size());

            for (PrimeGlobale primeGlobale : LPrimeG) {
                GrilleSalariale grilleSalariale = grilleSalarialeRepository.findByPrimeG(primeGlobale, bulletinSalaire.getIdBulletin(), contrat.getIdContrat());

                HashMap<String, Object> param = new HashMap<>();
                param.put("matricule", contrat.getAgent().getMatricule());
                param.put("nom", contrat.getAgent().getNomAgent() + "  " + contrat.getAgent().getPrenomAgent());
                param.put("sexe", contrat.getAgent().getGenre());
                //Date date = Date.from(contrat.getAgent().getDateEmbau().atStartOfDay(ZoneId.systemDefault()).toInstant());
                param.put("date", contrat.getAgent().getDateEmbau());
                param.put("compte", contrat.getAgent().getNumCompte());
                param.put("banque", contrat.getAgent().getInstitutionFinanciere().getNomInsti());
                param.put("mode", contrat.getAgent().getModeDePaiement().getLibelleModeP());
                param.put("contact", contrat.getAgent().getContact());
                param.put("situation", contrat.getAgent().getSituationMatrimoniale().getLibelleSitMat());
                param.put("titre", contrat.getAgent().getTitre().getLibelleTitre());
                param.put("fonction", contrat.getAgent().getFonction().getLibelleFonct());
                param.put("echellons", contrat.getEchelon().getLibelleEchel());
                param.put("categorie", contrat.getEchelon().getCategorie().getLibelleCateg());
                param.put("annee", bulletinSalaire.getAnnee().getLibelleAnnee());
                param.put("mois", bulletinSalaire.getMois().getLibelleMois());
                param.put("autre", "Salaire de base");
                param.put("type", "Salaire de base");
                param.put("totalBase", (double) Math.round(sommeSalaireBase));
                param.put("total", (double) Math.round(sommeSalaireBase));

                param.put("totalTaux", 1);
                param.put("salaireBrute", (double) Math.round(salaireBrut));
                param.put("salaireBase", salaireBase);
                param.put("salaireCnssEmp", cnssEmp);
                param.put("salaireCnssEmployeur", cnssPatr);

                param.put("rubrique", primeGlobale.getRubrique().getLibelleRubri());
                //Math.round(sommeSalaire)
                if (primeGlobale.getRubrique().getIdRubrique() == 1) {
                    param.put("base", (double) Math.round(grilleSalariale.getMontantSalaire()));
                }


                param.put("gainO", grilleSalariale.getMontantPrimeG());
                param.put("retenuO", (double) 0);
                param.put("tauxO", (double) 0);
                param.put("tauxP", (double) 0);
                param.put("retenueP", (double) 0);
                param.put("vps", valVps);
                param.put("ipts", valIpts);
                param.put("salaireNet", Math.round(salaireBrut - (valIpts + cnssEmp + irpp)));
                param.put("montantLettre", montantRetour);

                collection.add(param);

            }

            List<PrimeGlobale> LPrimeGlobale = grilleSalarialeRepository.findPrimeAllByContratBulletin(contrat.getIdContrat(), bulletinSalaire.getIdBulletin());
            System.out.println("DEBUT base Taille!1 " + LPrimeGlobale.size());
            System.out.println(contrat.getEchelon().getCategorie());

            for (PrimeGlobale primeGlobale : LPrimeGlobale) {
                GrilleSalariale grilleSalariale = grilleSalarialeRepository.findByPrimeG(primeGlobale, bulletinSalaire.getIdBulletin(), contrat.getIdContrat());
                System.out.println("montant primeG de grille***********"+grilleSalariale.getMontantPrimeG());
                HashMap<String, Object> param = new HashMap<>();
                param.put("matricule", contrat.getAgent().getMatricule());

                param.put("nom", contrat.getAgent().getNomAgent() + "  " + contrat.getAgent().getPrenomAgent());
                param.put("sexe", contrat.getAgent().getGenre());
                //Date date = Date.from(contrat.getAgent().getDateEmbau().atStartOfDay(ZoneId.systemDefault()).toInstant());
                param.put("date", contrat.getAgent().getDateEmbau());
                param.put("compte", contrat.getAgent().getNumCompte());
                param.put("banque", contrat.getAgent().getInstitutionFinanciere().getNomInsti());
                param.put("mode", contrat.getAgent().getModeDePaiement().getLibelleModeP());
                param.put("contact", contrat.getAgent().getContact());
                param.put("situation", contrat.getAgent().getSituationMatrimoniale().getLibelleSitMat());
                param.put("titre", contrat.getAgent().getTitre().getLibelleTitre());
                param.put("fonction", contrat.getAgent().getFonction().getLibelleFonct());
                param.put("echellons", contrat.getEchelon().getLibelleEchel());
                param.put("categorie", contrat.getEchelon().getCategorie().getLibelleCateg());
                param.put("annee", bulletinSalaire.getAnnee().getLibelleAnnee());
                param.put("mois", bulletinSalaire.getMois().getLibelleMois());
                param.put("autre", "primes fixes");
                param.put("type", "Total primes fixes");
                param.put("totalBase", (double) Math.round(sommePrimeG));
                param.put("total", (double) Math.round(sommeSalaireBase));

                param.put("totalTaux", 1);
                param.put("salaireBrute", (double) Math.round(salaireBrut));
                param.put("salaireBase", salaireBase);
                param.put("salaireCnssEmp", cnssEmp);
                param.put("salaireCnssEmployeur", cnssPatr);

                param.put("rubrique", primeGlobale.getRubrique().getLibelleRubri());
                //Math.round(sommeSalaire)

                param.put("base", 0.0);
                param.put("gainO", grilleSalariale.getMontantPrimeG());
                param.put("retenuO", (double) 0);
                param.put("tauxO", (double) 0);
                param.put("tauxP", (double) 0);
                param.put("retenueP", (double) 0);
                param.put("vps", valVps);
                param.put("ipts", valIpts);
                param.put("salaireNet", Math.round(salaireBrut - (valIpts + cnssEmp + irpp)));
                param.put("montantLettre", montantRetour);

                collection.add(param);

            }

            List<PrimeIndividuelle> LPrimeI = grilleSalarialeRepository.findPrimeIByContrat(contrat.getIdContrat(), bulletinSalaire.getIdBulletin());
            for (PrimeIndividuelle primeI : LPrimeI) {


                HashMap<String, Object> param = new HashMap<>();
                GrilleSalariale grilleSalariale = grilleSalarialeRepository.findByIdPrimeIndividuelle(primeI, bulletinSalaire);
                param.put("matricule", contrat.getAgent().getMatricule());

                param.put("nom", contrat.getAgent().getNomAgent() + "  " + contrat.getAgent().getPrenomAgent());
                param.put("sexe", contrat.getAgent().getGenre());
                // Date date = Date.from(contrat.getAgent().getDateEmbau().atStartOfDay(ZoneId.systemDefault()).toInstant());
                param.put("date",contrat.getAgent().getDateEmbau());
                param.put("compte", contrat.getAgent().getNumCompte());
                param.put("banque", contrat.getAgent().getInstitutionFinanciere().getNomInsti());
                param.put("mode", contrat.getAgent().getModeDePaiement().getLibelleModeP());
                param.put("contact", contrat.getAgent().getContact());
                param.put("situation", contrat.getAgent().getSituationMatrimoniale().getLibelleSitMat());
                param.put("titre", contrat.getAgent().getTitre().getLibelleTitre());
                param.put("fonction", contrat.getAgent().getFonction().getLibelleFonct());
                param.put("echellons", contrat.getEchelon().getLibelleEchel());
                param.put("categorie", contrat.getEchelon().getCategorie().getLibelleCateg());
                param.put("annee", bulletinSalaire.getAnnee().getLibelleAnnee());
                param.put("mois", bulletinSalaire.getMois().getLibelleMois());
                param.put("autre", "Prime individuelles");
                param.put("type", "Total primes individuelles");
                param.put("totalBase", sommePrimeI);
                param.put("salaireBrut", (double) Math.round(salaireBrut));
                param.put("salaireBase", (double) salaireBase);
                param.put("salaireCnssEmp", cnssEmp);
                param.put("salaireCnssEmployeur", cnssPatr);

                param.put("rubrique", primeI.getRubrique().getLibelleRubri());
                param.put("base", (double) 0);
                param.put("gainO", grilleSalariale.getMontantPrimeI());
                param.put("retenuO", (double) 0);
                param.put("tauxO", (double) 0);
                param.put("tauxP", (double) 0);
                param.put("retenuP", (double) 0);
                param.put("vps", valVps);
                param.put("ipts", valIpts);
                param.put("salaireNet", (double) Math.round(salaireBrut - (valIpts + cnssEmp + irpp)));
                param.put("montantLettre", montantRetour);
                collection.add(param);
            }
            List<Retenue> Lretenue = grilleSalarialeRepository.findByRetenue(contrat.getIdContrat(), bulletinSalaire.getIdBulletin());
            for (Retenue retenue : Lretenue) {
                GrilleSalariale grilleSalariale = grilleSalarialeRepository.findByIdRetenue(retenue, bulletinSalaire.getIdBulletin(), contrat.getIdContrat());

                HashMap<String, Object> param = new HashMap<>();
                param.put("matricule", contrat.getAgent().getMatricule());
                param.put("nom", contrat.getAgent().getNomAgent() + "  " + contrat.getAgent().getPrenomAgent());

                param.put("sexe", contrat.getAgent().getGenre());
               // Date date = Date.from(contrat.getAgent().getDateEmbau().atStartOfDay(ZoneId.systemDefault()).toInstant());
                param.put("date",contrat.getAgent().getDateEmbau());
                param.put("compte", contrat.getAgent().getNumCompte());
                System.out.println(""+contrat.getAgent().getNumCompte());
               // param.put("numeroCNSS",contrat.getAgent().getNumCompte());
                param.put("banque", contrat.getAgent().getInstitutionFinanciere().getNomInsti());
                param.put("mode", contrat.getAgent().getModeDePaiement().getLibelleModeP());
                param.put("contact", contrat.getAgent().getContact());
                param.put("situation", contrat.getAgent().getSituationMatrimoniale().getLibelleSitMat());
                param.put("titre", contrat.getAgent().getTitre().getLibelleTitre());
                param.put("fonction", contrat.getAgent().getFonction().getLibelleFonct());
                param.put("echellons", contrat.getEchelon().getLibelleEchel());
                param.put("categorie", contrat.getEchelon().getCategorie().getLibelleCateg());
                param.put("annee", bulletinSalaire.getAnnee().getLibelleAnnee());
                param.put("mois", bulletinSalaire.getMois().getLibelleMois());
                param.put("autre", "Retenue");
                param.put("type", "Salaire net");
                param.put("rubrique", retenue.getLibelleRetenue());

                if (retenue.getIdRetenue() == 3) {
                    param.put("base", (double) grilleSalariale.getTauxFixe());
                    param.put("retenuO", (double) Math.round((grilleSalariale.getTauxEmploy() / 100) * salaireBrut));

                    param.put("gainO", (double) 0);
                    param.put("tauxO", (double) 0);
                    param.put("tauxP", (double) 0);
                    param.put("retenuP", (double) 0);
                    param.put("salaireBrute", (double) Math.round(salaireBrut));
                    param.put("salaireBase", salaireBase);
                    param.put("salaireCnssEmp", cnssEmp);
                    param.put("salaireCnssEmployeur", cnssPatr);
                    param.put("vps", valVps);
                    param.put("ipts", valIpts);
                    param.put("salaireNet", (double) Math.round(salaireBrut - (valIpts + cnssEmp + irpp)));
                    param.put("montantLettre", montantRetour);

                } else if (retenue.getIdRetenue() == 2) {
                    int b = (int) (salaireBrut * 0.001);
                    int c = b * 1000;
                    salaireBase = c;

                    param.put("base", (double) b * 1000);
                    List<GrilleFiscale> LFiscale = grilleFiscaleRepository.findAll();
                    for (GrilleFiscale grilleFiscale : LFiscale) {
                        if (c >= grilleFiscale.getBorneInf() && c <= grilleFiscale.getBorneSup()) {
                            taux = grilleFiscale.getTaux();
                        }

                    }

                    param.put("retenuO", (double) Math.round((taux / 100) * c));
                    param.put("gainO", (double) 0);
                    param.put("tauxO", (double) 0);
                    param.put("tauxP", (double) grilleSalariale.getTauxPatron() / 100);
                    param.put("retenuP", (double) Math.round((grilleSalariale.getTauxPatron() / 100) * salaireBrut));
                    param.put("salaireBrute", (double) Math.round(salaireBrut));
                    param.put("salaireBase", (double) Math.round(salaireBase));
                    param.put("salaireCnssEmp", (double) Math.round(cnssEmp));
                    param.put("salaireCnssEmployeur", (double) Math.round(cnssPatr));

                    valIpts = (double) Math.round((taux / 100) * c);
                    valVps = (double) Math.round((grilleSalariale.getTauxPatron() / 100) * salaireBrut);

                    param.put("vps", valVps);
                    param.put("ipts", valIpts);
                    param.put("salaireNet", (double) Math.round(salaireBrut - (valIpts + cnssEmp + irpp)));
                    param.put("montantLettre", montantRetour);
                } else {
                    param.put("base", (double) Math.round(salaireBrut));
                    cnssEmp = Math.round((grilleSalariale.getTauxEmploy() / 100) * salaireBrut);
                    param.put("gainO", (double) 0);
                    param.put("retenuO", (double) Math.round((grilleSalariale.getTauxEmploy() / 100) * salaireBrut));
                    param.put("tauxO", (double) grilleSalariale.getTauxEmploy() / 100);
                    param.put("tauxP", (double) grilleSalariale.getTauxPatron() / 100);
                    cnssPatr = Math.round((grilleSalariale.getTauxPatron() / 100) * salaireBrut);
                    param.put("retenuP", (double) Math.round((grilleSalariale.getTauxPatron() / 100) * salaireBrut));

                    param.put("salaireBrute", (double) Math.round(salaireBrut));
                    param.put("salaireBase", (double) Math.round(salaireBase));
                    param.put("salaireCnssEmp", (double) Math.round(cnssEmp));
                    param.put("salaireCnssEmployeur", (double) Math.round(cnssPatr));
                    param.put("vps", (double) Math.round(valVps));
                    param.put("ipts", (double) Math.round(valIpts));
                    param.put("salaireNet", (double) Math.round(salaireBrut - (valIpts + cnssEmp + irpp)));
                    param.put("montantLettre", montantRetour);

                }

                double convertion = salaireBrut - (valIpts + cnssEmp);

                montantRetour = FrenchNumberToWords.convert((long) convertion);
                System.out.println("convertion"+convertion+"montant retout"+montantRetour);

                collection.add(param);
            }
                   RecapSalaire recapSalaire = recapSalaireRepository.findByIdContrat(contrat.getIdContrat(), bulletinSalaire.getIdBulletin());
                    if (recapSalaire == null)
                    {
                        recapSalaireRepository.save(new RecapSalaire((double)Math.round( salaireBrut - (valIpts+cnssEmp+irpp)), bulletinSalaire, contrat));
                    }
                    else
                    {
                        recapSalaire.setMontant((double)Math.round( salaireBrut - (valIpts+cnssEmp+irpp)));
                    }

                   // dataSource = new JRBeanCollectionDataSource(collection);
System.out.println(collection.size());

                }

                bulletinSalaire.setMontant(recapSalaireRepository.totalSalaire(bulletinSalaire.getIdBulletin()));
                bulletinSalaireRepository.save(bulletinSalaire);

              //  bulletinSalRepository.findAllOrdonly();
        dataSource = new JRBeanCollectionDataSource(collection);

               // bulletinSalaireRepository.save(bulletinSalaire);

     String reportDir="E:"+"/";
    InputStream jrxmlInput = new FileInputStream(new File(reportDir + "report_solde.jrxml"));
            JasperDesign design = JRXmlLoader.load(jrxmlInput);

            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();

            //JRCsvExporter csvExporter = new JRCsvExporter();

            pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
            pdfExporter.exportReport();

            response.setContentType("application/pdf");
            response.setHeader("Content-Length", String.valueOf(pdfReportStream.size()));
            response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");

            OutputStream responseOutputStream = response.getOutputStream();
            responseOutputStream.write(pdfReportStream.toByteArray());

            responseOutputStream.close();
            pdfReportStream.close();
        }


    }


