package com.vista.thymeleaf.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Vacantes")
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Double salario;
    private Integer destacado;
    private String imagen="no-imagen.png";
    private String estatus;
    private String detalles;
    //la anotacio @Trasient  se usa paraignorar los atributos y no se mapeen
    //@OneToOne, @ JoinColumn
    //1Parametro el nombre del campo de la llave foranea idCategoria
    @OneToOne
    @JoinColumn(name ="idCategoria" )
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getDestacado() {
        return destacado;
    }

    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String status) {
        this.estatus = estatus;
    }

    public String getDetalle() {
        return detalles;
    }

    public void setDetalle(String detalles) {
        this.detalles = detalles;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
