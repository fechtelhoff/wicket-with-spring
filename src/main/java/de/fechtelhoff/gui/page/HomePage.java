package de.fechtelhoff.gui.page;

import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import de.fechtelhoff.gui.common.HomePageLink;
import de.fechtelhoff.gui.common.page.BaseWebPage;
import de.fechtelhoff.gui.common.panel.WicketSettingsPanel;

@WicketHomePage
@SuppressWarnings("java:S110") // java:S110 -> Inheritance tree of classes should not be too deep
public class HomePage extends BaseWebPage {

	private static final List<HomePageLink> links = List.of(
		new HomePageLink("Personen Übersicht", OverviewPage.class)
	);

	public HomePage() {
		super();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final ListView<HomePageLink> listView = new ListView<>("listView", links) {
			@Override
			protected void populateItem(final ListItem<HomePageLink> item) {
				HomePageLink homePageLink = item.getModelObject();
				Link<Void> link = new BookmarkablePageLink<>("id", homePageLink.pageClass());
				link.add(new Label("label", homePageLink.label()));
				item.add(link);
			}
		};
		add(listView);

		add(new WicketSettingsPanel("wicketSettingsPanel"));
	}
}
