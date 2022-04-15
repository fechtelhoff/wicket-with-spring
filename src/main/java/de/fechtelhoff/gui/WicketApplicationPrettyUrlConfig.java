package de.fechtelhoff.gui;

import java.util.HashMap;
import java.util.Map;
import org.apache.wicket.markup.html.WebPage;
import de.fechtelhoff.gui.page.HomePage;
import de.fechtelhoff.gui.page.OverviewPage;

public final class WicketApplicationPrettyUrlConfig {

	private static final Map<String, Class<? extends WebPage>> CONFIG = new HashMap<>();

	static {
		//@formatter:off

		CONFIG.put("/home", HomePage.class);
		CONFIG.put("/home/overview", OverviewPage.class);

		//@formatter:on
	}

	private WicketApplicationPrettyUrlConfig() {
		// intentionally blank
	}

	public static Map<String, Class<? extends WebPage>> getPageClassByPrettyUrlMap() {
		return CONFIG;
	}
}
