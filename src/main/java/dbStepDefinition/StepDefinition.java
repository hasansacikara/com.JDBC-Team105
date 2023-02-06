package dbStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jsoup.select.Evaluator;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.createConnection;
import static utilities.DBUtils.getColumnData;

public class StepDefinition {

    List<Object> staffTablosundakiIDler = new ArrayList<>();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        createConnection();

    }

    @Given("staff tablosundaki {string} leri listeler.")
    public void staff_tablosundaki_leri_listeler(String Id) {
        staffTablosundakiIDler= getColumnData("SELECT * FROM u480337000_tlb_training.staff",Id);
        System.out.println(staffTablosundakiIDler);

    }

    @Given("verilen {string} dogrunalir.")
    public void verilen_dogrunalir(String string) {

    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {


        Assert.assertTrue(staffTablosundakiIDler.toString().contains("id"));
    }
}