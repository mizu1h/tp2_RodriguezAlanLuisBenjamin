package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private LocalDate fechaPago;
    private double montoPagado;

    public PagoEfectivo(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public void realizarPago(double monto) {
        montoPagado = monto - (monto * 0.10);
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
    }
}
