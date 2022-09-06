package ch.martinelli.wstage22.workshop.ui.views.participant;

import ch.martinelli.wstage22.workshop.entity.Participant;
import ch.martinelli.wstage22.workshop.repository.ParticipantRepository;
import ch.martinelli.wstage22.workshop.ui.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import org.springframework.data.domain.PageRequest;

@PageTitle("Participants")
@Route(layout = MainLayout.class)
public class ParticipantView extends VerticalLayout {

    private final Grid<Participant> grid = new Grid<>();

    public ParticipantView(ParticipantRepository participantRepository) {
        grid.addColumn(Participant::getFirstName)
                .setHeader("First Name")
                .setSortable(true).setSortProperty("firstName");
        grid.addColumn(Participant::getLastName)
                .setHeader("Last Name")
                .setSortable(true).setSortProperty("lastName");
        grid.addColumn(Participant::getEmail)
                .setHeader("E-Mail")
                .setSortable(true).setSortProperty("email");
        grid.addColumn(participant -> participant.getWorkshop() != null ? participant.getWorkshop().getTitle() : "")
                .setHeader("Workshop");

        grid.setMultiSort(true);

        grid.setItems(query -> participantRepository.findAll(
                        PageRequest.of(query.getPage(), query.getPageSize(),
                                VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());

        add(grid);
    }
}
