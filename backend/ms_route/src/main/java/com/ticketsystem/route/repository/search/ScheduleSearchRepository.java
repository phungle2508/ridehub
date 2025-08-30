package com.ticketsystem.route.repository.search;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryStringQuery;
import com.ticketsystem.route.domain.Schedule;
import com.ticketsystem.route.repository.ScheduleRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;

/**
 * Spring Data Elasticsearch repository for the {@link Schedule} entity.
 */
public interface ScheduleSearchRepository extends ElasticsearchRepository<Schedule, UUID>, ScheduleSearchRepositoryInternal {}

interface ScheduleSearchRepositoryInternal {
    Page<Schedule> search(String query, Pageable pageable);

    Page<Schedule> search(Query query);

    @Async
    void index(Schedule entity);

    @Async
    void deleteFromIndexById(UUID id);
}

class ScheduleSearchRepositoryInternalImpl implements ScheduleSearchRepositoryInternal {

    private final ElasticsearchTemplate elasticsearchTemplate;
    private final ScheduleRepository repository;

    ScheduleSearchRepositoryInternalImpl(ElasticsearchTemplate elasticsearchTemplate, ScheduleRepository repository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.repository = repository;
    }

    @Override
    public Page<Schedule> search(String query, Pageable pageable) {
        NativeQuery nativeQuery = new NativeQuery(QueryStringQuery.of(qs -> qs.query(query))._toQuery());
        return search(nativeQuery.setPageable(pageable));
    }

    @Override
    public Page<Schedule> search(Query query) {
        SearchHits<Schedule> searchHits = elasticsearchTemplate.search(query, Schedule.class);
        List<Schedule> hits = searchHits.map(SearchHit::getContent).stream().toList();
        return new PageImpl<>(hits, query.getPageable(), searchHits.getTotalHits());
    }

    @Override
    public void index(Schedule entity) {
        repository.findById(entity.getId()).ifPresent(elasticsearchTemplate::save);
    }

    @Override
    public void deleteFromIndexById(UUID id) {
        elasticsearchTemplate.delete(String.valueOf(id), Schedule.class);
    }
}
