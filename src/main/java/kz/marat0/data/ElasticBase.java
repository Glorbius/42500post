package kz.marat0.data;

import kz.marat0.model.Accounts;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticBase extends ElasticsearchRepository<Accounts,Integer> {


    Iterable<Accounts>findByIin(long iin);




}
