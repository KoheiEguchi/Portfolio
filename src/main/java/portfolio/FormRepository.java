package portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FormRepository extends JpaRepository<Form, Integer> {
	@Modifying
	@Query(value = "INSERT INTO form (name, address, content) VALUES (:name, :address, :content)", nativeQuery = true)
	public void newForm(String name, String address, String content);
}
