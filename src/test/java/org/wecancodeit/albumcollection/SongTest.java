package org.wecancodeit.albumcollection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class SongTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	SongRepository songRepo;

	@Resource
	AlbumRepository albumRepo;

	@Resource
	ArtistRepository artistRepo;

	@Test
	public void shouldAddAndGetSong() {

		Song song = songRepo.save(new Song("SongName", "3:33", "songLink", null));

		entityManager.persist(song);
		entityManager.flush();
		entityManager.clear();

		Long idToFind = 1L;
		Song songFromDB = songRepo.findById(idToFind).get();

		assertThat(songFromDB.getSongTitle(), is("SongName"));
	}
}
