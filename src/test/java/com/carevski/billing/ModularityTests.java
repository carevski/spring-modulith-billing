package com.carevski.billing;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.docs.Documenter.CanvasOptions;
import org.springframework.modulith.docs.Documenter.DiagramOptions;
import org.springframework.modulith.docs.Documenter.DiagramOptions.DiagramStyle;

class ModularityTests {

	ApplicationModules modules = ApplicationModules.of(Application.class);

	@Test
	void verifyModularity() {
		// --> Trigger verification
		modules.verify();
	}

	@Test
	void renderDocumentation() {

		var canvasOptions = CanvasOptions.defaults();

		var docOptions = DiagramOptions.defaults()
				.withStyle(DiagramStyle.UML);

		new Documenter(modules)
				.writeDocumentation(docOptions, canvasOptions);
	}
}
