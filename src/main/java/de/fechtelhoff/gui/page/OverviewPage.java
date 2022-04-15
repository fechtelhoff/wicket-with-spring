package de.fechtelhoff.gui.page;

import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;
import de.fechtelhoff.business.service.PersonBusinessService;
import de.fechtelhoff.business.service.bo.PersonBO;
import de.fechtelhoff.gui.common.page.BaseWebPage;

@SuppressWarnings("java:S110") // java:S110 -> Inheritance tree of classes should not be too deep
public class OverviewPage extends BaseWebPage {

	@SpringBean
	private PersonBusinessService personBusinessService;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new BookmarkablePageLink<>("backLink", HomePage.class));

		final List<PersonBO> personEntities = personBusinessService.lookupPersons();
		final ListDataProvider<PersonBO> listDataProvider = new ListDataProvider<>(personEntities);

		final DataView<PersonBO> dataView = new DataView<>("rows", listDataProvider) {

			@Override
			protected void populateItem(Item<PersonBO> item) {
				PersonBO personBO = item.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");

				repeatingView.add(new Label(repeatingView.newChildId(), personBO.id));
				repeatingView.add(new Label(repeatingView.newChildId(), personBO.firstName));
				repeatingView.add(new Label(repeatingView.newChildId(), personBO.lastName));
				repeatingView.add(new Label(repeatingView.newChildId(), personBO.version));
				repeatingView.add(new Label(repeatingView.newChildId(), personBO.added));
				repeatingView.add(new Label(repeatingView.newChildId(), personBO.modified));
				item.add(repeatingView);
			}
		};
		add(dataView);
	}
}
