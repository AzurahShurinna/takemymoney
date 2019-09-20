package technocite.be.takemymoney.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import technocite.be.takemymoney.model.OweMoney;


import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;
@Repository
public class OweRepositoryImpl implements OweDao {
    @Autowired
    private OweDao oweDao;

    private ArrayList<OweMoney> listDettes = newArrayList();

    @Override
    public List<OweMoney> findAll() {
        return listDettes;
    }

    @Override
    public OweMoney addDette(OweMoney oweMoney) {
     if (findById(oweMoney.getId()) == null){
         listDettes.add(oweMoney);

     }else {
         listDettes.remove(oweMoney);
         listDettes.add(oweMoney);
     }
     return findById(oweMoney.getId());
    }

    @Override
    public OweMoney findById(String id) {
        return listDettes.stream().filter(oweMoney -> oweMoney.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public boolean removeDette(String id) {

        OweMoney oweMoney = findById(id);

        if (oweMoney != null){
            return listDettes.remove(oweMoney);
        } else {
            System.out.println("veuillez entrer un numero de dette existant");
            return false;
        }



    }
}
