package technocite.be.takemymoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technocite.be.takemymoney.api.dto.OweDto;
import technocite.be.takemymoney.model.OweMoney;
import technocite.be.takemymoney.repository.OweDao;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class OweService implements Function<OweMoney, OweDto> {

    @Autowired
    private OweDao oweDao;

    public List<OweDto> ff(){
        return oweDao.findAll().stream().map(this).collect(toList());
    }

    public OweDto addDette(OweDto oweDto){
        OweMoney oweMoney1 = oweDao.findById(oweDto.getId());
        if ( oweMoney1 != null){
            System.out.println("this id already exist");
            return null;
        } else {
            return new OweDto(oweDto.getId(),oweDto.getUseroweId(),oweDto.getUserBorrowId(), oweDto.getPrice());
        }
       }



    public boolean removeDette(String id){
        return oweDao.removeDette(id);
    }

    public OweDto findById(String id){
        OweMoney oweMoney = oweDao.findById(id);
        if (oweMoney != null){
            return apply(oweMoney);
        }else {
            return null;
        }
    }

    public List<OweDto> searchByEmprunteur(String email ){
        return oweDao.findAll().stream()
                .filter(oweMoney -> oweMoney.getUserBorrowId().equals(email))
                .map(this::apply)
                .collect(toList());

    }
    public List<OweDto> searchByDonneur(String email){
        return oweDao.findAll().stream().filter(oweMoney -> oweMoney.getUserBorrowId().equals(email)).map(this::apply).collect(toList());
    }

    @Override
    public OweDto apply(OweMoney oweMoney) {
        return new OweDto(oweMoney.getId(),
                oweMoney.getUseroweId(),
                oweMoney.getUserBorrowId(),
                oweMoney.getPrice());
    }
}
