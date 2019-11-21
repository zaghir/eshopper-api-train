package com.bd.eshopper.api.train;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import com.bd.eshopper.api.train.entity.train.CompagnieFerroviaire;
import com.bd.eshopper.api.train.entity.train.Gare;
import com.bd.eshopper.api.train.entity.train.ReservationTrain;
import com.bd.eshopper.api.train.entity.train.Trajet;

import static org.assertj.core.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@JsonTest
@AutoConfigureJsonTesters
public class TrainApplicationJsonTests {
	
	private static Logger logger = LoggerFactory.getLogger(TrainApplicationJsonTests.class);
	
	@Autowired
	private JacksonTester<CompagnieFerroviaire> compagnieFerroviaireJson;
	
	@Autowired
	private JacksonTester<Gare> gareJson;
	
	@Autowired
	private JacksonTester<ReservationTrain> reservationTrainJson;
	
	@Autowired
	private JacksonTester<Trajet> trajetJson;
	
	@Test
	/**
	 * Simple test s'assurant que le contexte se charge correctement. Prérequis à tous les  autres tests.
	 */
	public void contextLoads() {
		logger.debug("Context successfully loaded");
	}
	
	@Test
	public void testSerializeCompagnieFerroviaire() throws Exception {
		CompagnieFerroviaire rjd = new CompagnieFerroviaire("RJD");
		JsonContent<CompagnieFerroviaire> compagnieFerroviaireJsonContent = this.compagnieFerroviaireJson.write(rjd);
		logger.debug("json compagnie ferroviaire : " + compagnieFerroviaireJsonContent.getJson());
		assertThat(compagnieFerroviaireJsonContent).hasJsonPathStringValue("@.nom");
		assertThat(compagnieFerroviaireJsonContent).extractingJsonPathStringValue("@.nom").isEqualTo("RJD");
	}
	
	@Test
	public void testDeserializeCompagnieFerroviaire() throws Exception {
		String content = "{\"nom\":\"RJD\"}";
		assertThat(this.compagnieFerroviaireJson.parseObject(content).getNom()).isEqualTo("RJD");
	}

	
	@Test
	public void testSerializeGare() throws Exception {
		Gare iaroslavl = new Gare("Iaroslavl", "Moscou");
		JsonContent<Gare> gareJsonContent = this.gareJson.write(iaroslavl);
		logger.debug("json gare : " + gareJsonContent.getJson());
		assertThat(gareJsonContent).hasJsonPathStringValue("@.nom");
		assertThat(gareJsonContent).extractingJsonPathStringValue("@.nom").isEqualTo("Iaroslavl");
		assertThat(gareJsonContent).hasJsonPathStringValue("@.ville");
		assertThat(gareJsonContent).extractingJsonPathStringValue("@.ville").isEqualTo("Moscou");
	}
	
	@Test
	public void testDeserializeGare() throws Exception {
		String content = "{\"nom\":\"Iaroslavl\",\"ville\":\"Moscou\"}";
		Gare gare = this.gareJson.parseObject(content); 
		assertThat(gare.getNom()).isEqualTo("Iaroslavl");
		assertThat(gare.getVille()).isEqualTo("Moscou");
	}
	
	
	@Test
	public void testSerializeReservationTrain() throws Exception {
		ReservationTrain reservationTrain = new ReservationTrain("1ère classe", 1);
		JsonContent<ReservationTrain> reservationTrainJsonContent = this.reservationTrainJson.write(reservationTrain);
		logger.debug("json réservation train : " + reservationTrainJsonContent.getJson());
		assertThat(reservationTrainJsonContent).hasJsonPathStringValue("@.typeReservation");
		assertThat(reservationTrainJsonContent).extractingJsonPathStringValue("@.typeReservation").isEqualTo("RT");
		assertThat(reservationTrainJsonContent).hasJsonPathStringValue("@.typeSiege");
		assertThat(reservationTrainJsonContent).extractingJsonPathStringValue("@.typeSiege").isEqualTo("1ère classe");
		assertThat(reservationTrainJsonContent).hasJsonPathNumberValue("@.nbPassagers");
		assertThat(reservationTrainJsonContent).extractingJsonPathNumberValue("@.nbPassagers").isEqualTo(1);
	}
	
	@Test
	public void testDeserializeReservationTrain() throws Exception {
		String content = "{\"typeReservation\":\"RT\",\"dateCreation\":\"2019-10-07T15:04:00.818+0000\",\"typeSiege\":\"1ère classe\",\"nbPassagers\":1}";
		ReservationTrain reservationTrain = this.reservationTrainJson.parseObject(content);
		assertThat(reservationTrain.getDateCreation()).isEqualTo(new Date(1570460640818L));
		assertThat(reservationTrain.getTypeSiege()).isEqualTo("1ère classe");
		assertThat(reservationTrain.getNbPassagers()).isEqualTo(1);
	}
	
	@Test
	public void testSerializeTrajet() throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dateHeureDepart = df.parse("09/10/2019 13:20");
		Date dateHeureArrivee = df.parse("15/10/2019 13:10");
		Trajet trajet = new Trajet(1, dateHeureDepart, dateHeureArrivee, "1ère classe", "Transsibérien", 1);
		
		trajet.setReservationTrain(new ReservationTrain("1ère classe", 1));
		trajet.setGareDepart(new Gare("Iaroslavl", "Moscou"));
		trajet.setGareArrivee(new Gare("Vladivostok", "Vladivostok"));
		trajet.setCompagnieFerroviaire(new CompagnieFerroviaire("RJD"));
		
		JsonContent<Trajet> trajetJsonContent = this.trajetJson.write(trajet);
		logger.debug("json trajet : " + trajetJsonContent.getJson());

		assertThat(trajetJsonContent).hasJsonPathNumberValue("@.numero");
		assertThat(trajetJsonContent).extractingJsonPathNumberValue("@.numero").isEqualTo(1);
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.dateHeureDepart");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.dateHeureDepart").isEqualTo("2019-10-09T11:20:00.000+0000");
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.dateHeureArrivee");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.dateHeureArrivee").isEqualTo("2019-10-15T11:10:00.000+0000");
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.classeVoyage");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.classeVoyage").isEqualTo("1ère classe");
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.typeTrain");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.typeTrain").isEqualTo("Transsibérien");
		assertThat(trajetJsonContent).hasJsonPathNumberValue("@.nbPlaces");
		assertThat(trajetJsonContent).extractingJsonPathNumberValue("@.nbPlaces").isEqualTo(1);
		
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.reservationTrain.typeReservation");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.reservationTrain.typeReservation").isEqualTo("RT");
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.reservationTrain.typeSiege");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.reservationTrain.typeSiege").isEqualTo("1ère classe");
		assertThat(trajetJsonContent).hasJsonPathNumberValue("@.reservationTrain.nbPassagers");
		assertThat(trajetJsonContent).extractingJsonPathNumberValue("@.reservationTrain.nbPassagers").isEqualTo(1);
		
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.gareDepart.nom");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.gareDepart.nom").isEqualTo("Iaroslavl");
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.gareDepart.ville");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.gareDepart.ville").isEqualTo("Moscou");
		
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.gareArrivee.nom");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.gareArrivee.nom").isEqualTo("Vladivostok");
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.gareArrivee.ville");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.gareArrivee.ville").isEqualTo("Vladivostok");
		
		assertThat(trajetJsonContent).hasJsonPathStringValue("@.compagnieFerroviaire.nom");
		assertThat(trajetJsonContent).extractingJsonPathStringValue("@.compagnieFerroviaire.nom").isEqualTo("RJD");
	}
	
	@Test
	public void testDeserializeTrajet() throws Exception {
		String content = "{\"id\":null,\"numero\":1,\"dateHeureDepart\":\"2019-10-09T11:20:00.000+0000\",\"dateHeureArrivee\":\"2019-10-15T11:10:00.000+0000\",\"classeVoyage\":\"1ère classe\",\"typeTrain\":\"Transsibérien\",\"nbPlaces\":1,\"reservationTrain\":{\"typeReservation\":\"RT\",\"id\":null,\"codeReservation\":null,\"dateCreation\":\"2019-10-08T08:24:30.717+0000\",\"idPaiement\":null,\"facture\":null,\"client\":null,\"typeSiege\":\"1ère classe\",\"nbPassagers\":1,\"trajets\":null},\"gareDepart\":{\"id\":null,\"nom\":\"Iaroslavl\",\"ville\":\"Moscou\"},\"gareArrivee\":{\"id\":null,\"nom\":\"Vladivostok\",\"ville\":\"Vladivostok\"},\"compagnieFerroviaire\":{\"id\":null,\"nom\":\"RJD\"}}";
		
		Trajet trajet = this.trajetJson.parseObject(content);
		
		assertThat(trajet.getNumero()).isEqualTo(1);
		assertThat(trajet.getDateHeureDepart().getTime()).isEqualTo(1570620000000L);
		assertThat(trajet.getDateHeureArrivee().getTime()).isEqualTo(1571137800000L);
		assertThat(trajet.getClasseVoyage()).isEqualTo("1ère classe");
		assertThat(trajet.getTypeTrain()).isEqualTo("Transsibérien");
		assertThat(trajet.getNbPlaces()).isEqualTo(1);
		
		assertThat(trajet.getReservationTrain().getDateCreation().getTime()).isEqualTo(1570523070717L);
		assertThat(trajet.getReservationTrain().getTypeSiege()).isEqualTo("1ère classe");
		assertThat(trajet.getReservationTrain().getNbPassagers()).isEqualTo(1);
		
		assertThat(trajet.getGareDepart().getNom()).isEqualTo("Iaroslavl");
		assertThat(trajet.getGareDepart().getVille()).isEqualTo("Moscou");
		
		assertThat(trajet.getGareArrivee().getNom()).isEqualTo("Vladivostok");
		assertThat(trajet.getGareArrivee().getVille()).isEqualTo("Vladivostok");
		
		assertThat(trajet.getCompagnieFerroviaire().getNom()).isEqualTo("RJD");
	}
}
