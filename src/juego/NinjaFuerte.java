package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class NinjaFuerte {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private double velocidad;
	private Image img1;
	
	public NinjaFuerte(double x, double y) {
		this.x = x;
		this.y = y;
		this.velocidad = 1;
		this.img1 = Herramientas.cargarImagen("ninjaFuerte.png");
		this.alto = img1.getHeight(null);
		this.ancho = img1.getWidth(null);
	}
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(img1, x, y, Math.PI * 2);
	}

	public void mover(double angulo) {
		// angulo = orientacion de ninja
		if (angulo == 0.0) { // izquierda a derecha
			x += velocidad;
		} else if (angulo == Math.PI) { // derecha a izquierda
			x -= velocidad;
		} else if (angulo == Math.PI / 2) { // abajo hacia arriba
			y -= velocidad;
		} else if (angulo == -Math.PI / 2) { // arriba hacia abajo
			y += velocidad;
		}

	}
	
	public boolean chocasteConElEntorno(Entorno e) {
		return x <= alto / 2 || x >= e.ancho() - alto / 2 || 
				y <= ancho / 2 || y >= e.alto() - ancho / 2;
	}
}
