package hr.fer.zemris.lsystems.impl.demo;

import hr.fer.zemris.lsystems.LSystem;
import hr.fer.zemris.lsystems.LSystemBuilderProvider;
import hr.fer.zemris.lsystems.gui.LSystemViewer;
import hr.fer.zemris.lsystems.impl.LSystemBuilderImpl;

/**
 * Razred koji služi za demonstraciju rada razreda {@link LSystemBuilderImpl}.
 * 
 * @author Maja Radočaj
 *
 */
public class Glavni1 {

	/**
	 * Glavni program.
	 * 
	 * @param args argumenti naredbenog retka
	 */
	public static void main(String[] args) {
		LSystemViewer.showLSystem(createKochCurve(LSystemBuilderImpl::new));
	}

	/**
	 * Metoda koja stvara novu Kochovu krivulju.
	 * 
	 * @param provider objekt koji zna stvarati objekte za konfiguriranje
	 *                 Lindermayerovih sustava
	 * @return novi Lindermayerov sustav
	 */
	private static LSystem createKochCurve(LSystemBuilderProvider provider) {
		return provider.createLSystemBuilder()
			.registerCommand('F', "draw 1")
			.registerCommand('+', "rotate 60")
			.registerCommand('-', "rotate -60")
			.setOrigin(0.05, 0.4)
			.setAngle(0)
			.setUnitLength(0.9)
			.setUnitLengthDegreeScaler(1.0/3.0)
			.registerProduction('F', "F+F--F+F")
			.setAxiom("F")
			.build();
		}

}