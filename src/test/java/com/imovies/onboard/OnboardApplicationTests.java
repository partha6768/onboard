package com.imovies.onboard;

import com.imovies.onboard.resource.movie.entity.Movie;
import com.imovies.onboard.resource.movie.entity.MovieViewType;
import com.imovies.onboard.resource.city.CityRepository;
import com.imovies.onboard.resource.movie.repository.MovieRepository;
import com.imovies.onboard.resource.movie.vo.MovieVO;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
class OnboardApplicationTests {

	//@Test
	void contextLoads() {
	}

	@Autowired
	CityRepository cityRepository;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	MovieRepository movieRepository;

	//@Test
	public void givenMovieVo_validateGenre_shouldNotBeEmpty() {

		//Given
		MovieVO movieVO = new MovieVO();
		Predicate<MovieVO> filterGen = x -> StringUtils.isNotEmpty(x.getGenere());
		Predicate<MovieVO> filterTitle = x -> StringUtils.isNotEmpty(x.getTitle());

		//filterGen.and()

		//Then
		boolean isGenre = filterGen.test(movieVO);

		//Assert
		Assert.assertTrue(isGenre);

	}


	//@Test


	//@Transactional
	public void test() throws InterruptedException {
		Movie movie = new Movie();
		movie.setTitle("Movie1");
		movie.setDescription("Desc");
		movie.setMovieTypeName("Movie");
		movie.setGenere("Action");
		movie.setDuration("2h");
		movie.setThumbnailUrl("http://url");
		movie.setTrailerUrl("http://url");
		movie.setReleaseTs(LocalDateTime.now());

		MovieViewType movieViewType1 = new MovieViewType();
		movieViewType1.setViewTypeName("3D");
		movieViewType1.setLanguageName("Hindi");
		MovieViewType movieViewType2 = new MovieViewType();
		movieViewType2.setViewTypeName("2D");
		movieViewType2.setLanguageName("Hindi");
		List<MovieViewType> movieViewTypes = new ArrayList<>();
		movieViewTypes.add(movieViewType1);
		movieViewTypes.add(movieViewType2);

		movie.setMovieViewTypes(movieViewTypes);
		movieRepository.save(movie);

		//Thread.sleep(100000);
//		em.persist(movie);
//		em.persist(movieViewType1);
//		em.persist(movieViewType2);


	}
}
