package filmography.ARZ.repos.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Film {
    private Long id;
    private String title;
    private String url;
    private int year;
    private boolean watched;
}
