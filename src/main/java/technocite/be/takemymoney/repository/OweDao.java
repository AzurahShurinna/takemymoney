package technocite.be.takemymoney.repository;

import technocite.be.takemymoney.model.OweMoney;
import technocite.be.takemymoney.model.User;

import java.util.List;

public interface OweDao {

    List<OweMoney> ff();

    OweMoney addDette(OweMoney oweMoney);

    boolean removeDette(OweMoney oweMoney);

    OweMoney findById(String id);


}
