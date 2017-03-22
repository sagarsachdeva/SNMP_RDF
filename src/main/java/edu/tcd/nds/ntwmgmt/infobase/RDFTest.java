package edu.tcd.nds.ntwmgmt.infobase;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;

public class RDFTest {
	public static void main(String[] args) {
		QueryExecution qe = QueryExecutionFactory.sparqlService("http://localhost:3030/ds/query",
				"SELECT * WHERE {?x ?r ?y}");
		ResultSet results = qe.execSelect();
		while (results.hasNext()) {
			QuerySolution rs = results.next();
			Resource subject = rs.getResource("x");
			Resource predicate = rs.getResource("r");
			Resource object = rs.getResource("y");
			System.out.println("Subject: " + subject + "\tPredicate: " + predicate + "\tObject: " + object);
		}
		qe.close();
	}

}
