package org.springframework.samples.petclinic.cause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.exchange.Currency;
import org.springframework.samples.petclinic.exchange.ExchangeCurrency;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CauseService {

    private CauseRepository causeRepository;

    @Autowired
    public CauseService(CauseRepository cr){
        this.causeRepository = cr;

    }

    @Transactional
    public void save(Cause cause){
        causeRepository.save(cause);
    }

    @Transactional(readOnly = true)
    public List<Cause> getAllCauses(){
        return causeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Cause> getCauseById(Integer id){
        return causeRepository.findById(id);
    }


    @Transactional
    public void deleteCauseById(Integer id){
        causeRepository.deleteById(id);
    }

    @Transactional

    public void editCause(Cause c) throws DataAccessException{
        Cause toUpdate = causeRepository.findById(c.getId()).orElse(null);
        if(!toUpdate.equals(null)){
            toUpdate.setId(c.getId());
            toUpdate.setBudgetTarget(c.getBudgetTarget());
            toUpdate.setDescription(c.getDescription());
            toUpdate.setDonations(c.getDonations());
            toUpdate.setIsClosed(c.getIsClosed());
            toUpdate.setName(c.getName());
            toUpdate.setNonProfitOrganization(c.getNonProfitOrganization());
        }
        causeRepository.save(toUpdate);
    }
@Transactional  
public Map<Cause,List<ExchangeCurrency>> findAllCausesByExchangeCurrency(Currency currency){
    List<Cause> causes = causeRepository.findAll();
    Map<Cause,List<ExchangeCurrency>> causeBudgets = new HashMap<>();
        for(Cause c: causes){
            List<ExchangeCurrency> budgets = new ArrayList<>();
            ExchangeCurrency ec1 = new ExchangeCurrency(Currency.USD, c.getBudgetTarget());
            ExchangeCurrency ec2 = new ExchangeCurrency(Currency.USD, c.getAchievedBudget());
            ec1 = ec1.convertTo(currency);
            ec2 = ec2.convertTo(currency);
            budgets.add(ec1);
            budgets.add(ec2);
            causeBudgets.put(c, budgets);
        }

        return causeBudgets;
    
}
@Transactional
public void checkCauses(){
    for(Cause c: causeRepository.findAll()){
        if(c.getAchievedBudget()>=c.getBudgetTarget()){
            c.setIsClosed(true);
            editCause(c);
        }
    }
}

}
