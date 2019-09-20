package technocite.be.takemymoney.repository;

import technocite.be.takemymoney.model.OweMoney;
import technocite.be.takemymoney.model.User;

import java.util.List;

public interface OweDao {

    List<OweMoney> findAll();

    OweMoney addDette(OweMoney oweMoney);

    boolean removeDette(String id);

    OweMoney findById(String id);




}
