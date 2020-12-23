package main.service;

import lombok.extern.log4j.Log4j2;
import main.api.request.PresentationRequest;
import main.model.Presentation;
import main.repository.PresentationRepository;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PresentationService
{
    private final PresentationRepository presentationRepository;

    public PresentationService(PresentationRepository presentationRepository)
    {
        this.presentationRepository = presentationRepository;
    }

    public void deletePresentation(int idPresentation)
    {
        presentationRepository.deleteById(idPresentation);
    }

    public Presentation getPresentation(int id)
    {
        Presentation presentation = presentationRepository.findById(id).get();
        return presentation;
    }

    public void savePresentation(Presentation presentation)
    {
        presentationRepository.save(presentation);
    }

    public void updatePresentation(PresentationRequest presentation)
    {
        Presentation pre = presentationRepository.getOne(presentation.getId());

        if (pre != null)
        {
            pre.setTheme(presentation.getTheme());
            pre.setContent(presentation.getContent());
            pre.setUsers(presentation.getUsers());

            presentationRepository.save(pre);
        }
    }
}
