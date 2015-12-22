package model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Zeballos on 12/12/15.
 */



@ParseClassName("DatosPersonalesModel")
public class DatosPersonalesModel extends ParseObject {
    private String datosNombre;
    private String datosEdad;
    private String datosEstadoCivil;
    private String datosNacionalidad;
    private String datosOcupacion;
    private String datosDomicilio;
    private String datosResponsable;
    private String datosSexo;
    public DatosPersonalesModel(){

    }
//    public String getDatosNombre() {
//        return datosNombre;
//    }

    public void setDatosNombre(String datosNombre) {
        put("datosNombre", datosNombre);
    }

    public String getDatosEdad() {
        return datosEdad;
    }

    public void setDatosEdad(String datosEdad) {
        this.datosEdad = datosEdad;
    }

    public String getDatosEstadoCivil() {
        return datosEstadoCivil;
    }

    public void setDatosEstadoCivil(String datosEstadoCivil) {
        this.datosEstadoCivil = datosEstadoCivil;
    }

    public String getDatosNacionalidad() {
        return datosNacionalidad;
    }

    public void setDatosNacionalidad(String datosNacionalidad) {
        this.datosNacionalidad = datosNacionalidad;
    }

    public String getDatosOcupacion() {
        return datosOcupacion;
    }

    public void setDatosOcupacion(String datosOcupacion) {
        this.datosOcupacion = datosOcupacion;
    }

    public String getDatosDomicilio() {
        return datosDomicilio;
    }

    public void setDatosDomicilio(String datosDomicilio) {
        this.datosDomicilio = datosDomicilio;
    }

    public String getDatosResponsable() {
        return datosResponsable;
    }

    public void setDatosResponsable(String datosResponsable) {
        this.datosResponsable = datosResponsable;
    }

    public String getDatosSexo() {
        return datosSexo;
    }

    public void setDatosSexo(String datosSexo) {
        this.datosSexo = datosSexo;
    }
}
