package de.fechtelhoff.gui.common;

import java.io.Serializable;
import org.apache.wicket.markup.html.WebPage;

public record HomePageLink(String label, Class<? extends WebPage> pageClass) implements Serializable {

}
