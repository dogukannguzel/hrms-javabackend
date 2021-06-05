package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeGetDto {

    private int id;
    private int candidateId;
    private String githubLink;
    private String linkedLink;
    private String photo;
    private String cvDescription;
    private List<EducationGetDto> educations = new ArrayList<>();
    private List<JobExperienceGetDto> jobExperiences = new ArrayList<>();
    private List<LanguageGetDto> languages = new ArrayList<>();
    private List<TechonologyGetDto> technologies = new ArrayList<>();

}
