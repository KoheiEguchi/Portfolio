package portfolio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FormRepository extends JpaRepository<Form, Integer> {
	//連絡取得
	@Query(value = "SELECT * FROM form ORDER BY form_date DESC", nativeQuery = true)
	public List<Form> getForm();
	
	//連絡追加
	@Modifying
	@Query(value = "INSERT INTO form (name, address, content) VALUES (:name, :address, :content)", nativeQuery = true)
	public void newForm(String name, String address, String content);
	
	//連絡削除
	@Modifying
	@Query(value = "DELETE FROM form WHERE id = :id", nativeQuery = true)
	public void formDelete(int id);
}
