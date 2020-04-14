/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beranda;

/**
 *
 * @author Kurnia Indah N
 */
public class MVC_Buk {
    
    ViewBuku viewbuku = new ViewBuku();
    ModelBuku modelbuku = new ModelBuku();
    ControllerBuku controllerbuku = new ControllerBuku (modelbuku, viewbuku);
}
