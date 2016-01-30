package a1.waiyi_fueltrack;

import java.text.DecimalFormat;
import java.util.Date;


import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class Entry
{
    private Date date;
    private String station;
    private double odometer;
    private String grade;
    private double amount;
    private double unitCost;
    private double total;

    public Entry(Date aDate, String aStation, double aOdometer, String aGrade, double aAmount,
                 double aUnitCost, double aTotal)
    {
        this.date = aDate;
        this.station = aStation;
        this.odometer = aOdometer;
        this.grade = aGrade;
        this.amount= aAmount;
        this.unitCost = aUnitCost;
        this.total = aTotal;
        updateTotalCost();

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date aDate) {
        this.date = aDate;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String aStation) {
        this.station = aStation;
    }

    public double getOdometer() {
        return (odometer);
    }

    public void setOdometer(double aOdometer){
        this.odometer = aOdometer;
        this.odometer = Double.parseDouble(new DecimalFormat("##.#").format(this.odometer));
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String aGrade){
        this.grade = aGrade;
    }

    public double getAmount(){
        return amount;
    }
//TODO: check if the right variable set to the proper format
    public void setAmount(double aAmount) {
        this.amount = aAmount;
        this.amount =Double.parseDouble(new DecimalFormat("##.###").format(this.amount));
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double aUnitCost){
        this.unitCost = aUnitCost;
        this.unitCost = Double.parseDouble(new DecimalFormat("##.#").format(this.unitCost));
        updateTotalCost();
    }

    private void updateTotalCost(){
        total = amount * (unitCost/100.0);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double aTotal) {
        this.total = aTotal;
        this.total = Double.parseDouble(new DecimalFormat("##.##").format(this.total));
    }
}
