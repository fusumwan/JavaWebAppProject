
package com.eng.sentence.domain.repositories;
import java.util.List;
import com.eng.sentence.domain.models.data.TableField;

public interface TableRepository {
    List<TableField> getTableFields(String tablename);
}

