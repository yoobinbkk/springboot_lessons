package com.example.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.domain.BoardVO;

public interface QueryAnnoRepository extends CrudRepository<BoardVO, Integer> {
	
	// [1] JPQL (복잡한 쿼리)
	@Query("SELECT b FROM BoardVO b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	List<BoardVO> queryAnnotation(String word);
	
	// [2] SQL (복잡한 쿼리, 진짜 SQL 문장으로 만들어야할 만큼)
	@Query(value="SELECT * FROM board WHERE title LIKE '%'||?1||'%' ORDER BY seq DESC", nativeQuery=true)
	List<BoardVO> queryAnnotation2(String word);
	
	// [2.1] SQL (복잡한 쿼리, 진짜 SQL 문장으로 만들어야할 만큼)
	@Query(value="SELECT SEQ, TITLE, WRITER, content, REGDATE, CNT FROM board WHERE title LIKE '%'||?1||'%' ORDER BY seq DESC", nativeQuery=true)
	List<BoardVO> queryAnnotation3(String word);
	
	// [3]과제 : SQL (복잡한 쿼리, 조인인 경우)
	// 		board2와 board_file
	// 		레코드 리턴값 BoardVO 안 나옴 -> Object[] / HashMap 등으로 처리
	//[3] SQL join : board + board_file :: record returns HashMap instead of BoardVO
   @Query(value="SELECT b.seq seq, b.title title, b.writer writer, b.regdate regdate, b.cnt cnt, bf.filepath filepath FROM BOARD2 b "
         + "left outer join BOARD_FILE bf ON b.fileid = bf.fileid", nativeQuery=true)
   List<Object[]> queryAnnotation4();
   
//   //[3] SQL join : board + board_file :: record returns HashMap instead of BoardVO
//   @Query(value="SELECT b.seq as seq, b.title title, b.writer , b.regdate, b.cnt, bf.filepath FROM BOARD b "
//         + "full outer join BOARD_FILE bf ON b.title = bf.filename "
//         + "where b.title like '%'||?1||'%' order by b.seq desc", nativeQuery=true)
//   List<Object[]> queryAnnotation3(String word);
	
	
	
}
