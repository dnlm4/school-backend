
/*package org.softfisticado.infrastructure.adapters.output;


import java.util.List;

@ApplicationScoped
public class SubjectRepositoryImpl extends QueryJobImpl<Subject> implements SubjectRepository {

    @Inject
    Pool pool;

    MutinyPool mutinyPool;

    @PostConstruct
    void init() {
        mutinyPool = MutinyPool.newInstance(pool);
    }

    @Override
    public Uni<Subject> save(Subject subject) {
        List<Object> attributeData = this.buildQuery(subject);
        System.out.println("attributeData0 subject---- " + attributeData.get(0));
        System.out.println("attributeData1 subject---- " + attributeData.get(1));

        Object paramData = attributeData.get(1);

        if (!(paramData instanceof List<?> rawValues)) {
            throw new IllegalStateException("Los parámetros no son una lista: " + paramData);
        }

        Tuple valuesTuple = Tuple.tuple();
        for (Object val : rawValues) {
            valuesTuple.addValue(val);
        }

        return mutinyPool.preparedQuery(attributeData.get(0).toString())
                .execute(valuesTuple)
                .onItem().transform(pgRow -> {
                    Row row = pgRow.iterator().next();
                    subject.setId(row.getLong("id"));
                    return subject;
                });
    }
}
*/