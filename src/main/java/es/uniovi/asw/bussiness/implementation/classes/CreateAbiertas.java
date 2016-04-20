package es.uniovi.asw.bussiness.implementation.classes;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.OpenList;
import es.uniovi.asw.parser.RCandidateExcel;

import java.util.List;

/**
 * Created by ignaciofernandezalvarez on 20/4/16.
 */
public class CreateAbiertas {
    private OpenList openList;

    public CreateAbiertas(OpenList openList) {
        this.openList = openList;
    }

    public boolean create() {

        List<Candidate> candidatos = new RCandidateExcel().readFile("src/main/test/resourceselecciones.xlsx");

        try {


            System.out.println(candidatos);
            Repository.electionR.save(openList);

            for (Candidate candidate : candidatos) {
                candidate.addElection(openList);
                Repository.candidateR.save(candidate);
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


        return true;


    }
}


