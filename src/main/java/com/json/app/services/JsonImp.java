package com.json.app.services;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.app.domain.MovieEntity;
import com.json.app.repository.MovieRepository;
import com.json.app.web.mapper.MovieMapper;
import com.json.app.web.model.MovieDTO;
import com.json.app.web.model.MovieResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@Service
public class JsonImp implements JsonService{
	
	private final ObjectMapper objectMapper;
	private final MovieRepository movieRepository;
	private final MovieMapper movieMapper;
	
	
	public Integer checkData() {
		return this.movieRepository.findAll().size();
	}
	
	
	@Override
	public MovieEntity newMovie(MovieDTO dto) {
		MovieEntity entity = movieMapper.movieDTOtoMovieEntity(dto);
		return this.movieRepository.save(entity);
	}

	@Override
	@Transactional
	public List<MovieDTO> getAll() {
		
		if(this.checkData()==0) {
				this.createMovieObjects();
			return null;
			
		} else 
		
		
		 return this.movieRepository.findAll().stream()
				.map(movieMapper::movieEntitytoMovieDTO)
				 .collect(Collectors.toList());
	}
	
	
	
	private void createMovieObjects() {
	
		try {
			MovieResponse movres = this.DeserializeOrigin();
			System.out.print(movres.getResults());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void delete(MovieDTO dto) {
		MovieEntity entity = movieMapper.movieDTOtoMovieEntity(dto);
		this.movieRepository.deleteById(entity.getId());
	}
	
	
	
	 public  MovieResponse DeserializeOrigin() throws IOException {
	        String json = "{\r\n"
	        		+ "  \"page\": 1,\r\n"
	        		+ "  \"results\": [\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/iZLqwEwUViJdSkGVjePGhxYzbDb.jpg\",\r\n"
	        		+ "      \"genre_ids\": [878, 53],\r\n"
	        		+ "      \"id\": 755898,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"War of the Worlds\",\r\n"
	        		+ "      \"overview\": \"Will Radford is a top analyst for Homeland Security who tracks potential threats through a mass surveillance program, until one day an attack by an unknown entity leads him to question whether the government is hiding something from him... and from the rest of the world.\",\r\n"
	        		+ "      \"popularity\": 1106.8877,\r\n"
	        		+ "      \"poster_path\": \"/yvirUYrva23IudARHn3mMGVxWqM.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-07-29\",\r\n"
	        		+ "      \"title\": \"War of the Worlds\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 4.248,\r\n"
	        		+ "      \"vote_count\": 408\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/ZtcGMc204JsNqfjS9lU6udRgpo.jpg\",\r\n"
	        		+ "      \"genre_ids\": [28, 18],\r\n"
	        		+ "      \"id\": 911430,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"F1\",\r\n"
	        		+ "      \"overview\": \"Racing legend Sonny Hayes is coaxed out of retirement to lead a struggling Formula 1 team—and mentor a young hotshot driver—while chasing one more chance at glory.\",\r\n"
	        		+ "      \"popularity\": 812.4176,\r\n"
	        		+ "      \"poster_path\": \"/9PXZIUsSDh4alB80jheWX4fhZmy.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-06-25\",\r\n"
	        		+ "      \"title\": \"F1\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.791,\r\n"
	        		+ "      \"vote_count\": 1481\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/538U9snNc2fpnOmYXAPUh3zn31H.jpg\",\r\n"
	        		+ "      \"genre_ids\": [28, 12, 53],\r\n"
	        		+ "      \"id\": 575265,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Mission: Impossible - The Final Reckoning\",\r\n"
	        		+ "      \"overview\": \"Ethan Hunt and team continue their search for the terrifying AI known as the Entity — which has infiltrated intelligence networks all over the globe — with the world's governments and a mysterious ghost from Hunt's past on their trail. Joined by new allies and armed with the means to shut the Entity down for good, Hunt is in a race against time to prevent the world as we know it from changing forever.\",\r\n"
	        		+ "      \"popularity\": 616.3361,\r\n"
	        		+ "      \"poster_path\": \"/z53D72EAOxGRqdr7KXXWp9dJiDe.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-05-17\",\r\n"
	        		+ "      \"title\": \"Mission: Impossible - The Final Reckoning\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.241,\r\n"
	        		+ "      \"vote_count\": 1405\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/eU7IfdWq8KQy0oNd4kKXS0QUR08.jpg\",\r\n"
	        		+ "      \"genre_ids\": [878, 12, 28],\r\n"
	        		+ "      \"id\": 1061474,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Superman\",\r\n"
	        		+ "      \"overview\": \"Superman, a journalist in Metropolis, embarks on a journey to reconcile his Kryptonian heritage with his human upbringing as Clark Kent.\",\r\n"
	        		+ "      \"popularity\": 625.4189,\r\n"
	        		+ "      \"poster_path\": \"/ombsmhYUqR4qqOLOxAyr5V8hbyv.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-07-09\",\r\n"
	        		+ "      \"title\": \"Superman\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.562,\r\n"
	        		+ "      \"vote_count\": 2600\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/xk0ck8qmYmevisTmphWIDm1g43p.jpg\",\r\n"
	        		+ "      \"genre_ids\": [53, 28, 35],\r\n"
	        		+ "      \"id\": 1151334,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Eenie Meanie\",\r\n"
	        		+ "      \"overview\": \"A former teenage getaway driver gets dragged back into her unsavory past when a former employer offers her a chance to save the life of her chronically unreliable ex-boyfriend.\",\r\n"
	        		+ "      \"popularity\": 585.1001,\r\n"
	        		+ "      \"poster_path\": \"/12Va3oO3oYUdOd75zM57Nx1976a.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-08-21\",\r\n"
	        		+ "      \"title\": \"Eenie Meanie\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 6.742,\r\n"
	        		+ "      \"vote_count\": 64\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/zNriRTr0kWwyaXPzdg1EIxf0BWk.jpg\",\r\n"
	        		+ "      \"genre_ids\": [878, 12, 28],\r\n"
	        		+ "      \"id\": 1234821,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Jurassic World Rebirth\",\r\n"
	        		+ "      \"overview\": \"Five years after the events of Jurassic World Dominion, covert operations expert Zora Bennett is contracted to lead a skilled team on a top-secret mission to secure genetic material from the world's three most massive dinosaurs. When Zora's operation intersects with a civilian family whose boating expedition was capsized, they all find themselves stranded on an island where they come face-to-face with a sinister, shocking discovery that's been hidden from the world for decades.\",\r\n"
	        		+ "      \"popularity\": 396.0181,\r\n"
	        		+ "      \"poster_path\": \"/1RICxzeoNCAO5NpcRMIgg1XT6fm.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-07-01\",\r\n"
	        		+ "      \"title\": \"Jurassic World Rebirth\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 6.37,\r\n"
	        		+ "      \"vote_count\": 1819\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/jvpkBenB6hv19WWYVlaiow8zklq.jpg\",\r\n"
	        		+ "      \"genre_ids\": [16, 10751, 35, 80, 12],\r\n"
	        		+ "      \"id\": 1175942,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"The Bad Guys 2\",\r\n"
	        		+ "      \"overview\": \"The now-reformed Bad Guys are trying (very, very hard) to be good, but instead find themselves hijacked into a high-stakes, globe-trotting heist, masterminded by a new team of criminals they never saw coming: The Bad Girls.\",\r\n"
	        		+ "      \"popularity\": 315.8297,\r\n"
	        		+ "      \"poster_path\": \"/26oSPnq0ct59l07QOXZKyzsiRtN.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-07-24\",\r\n"
	        		+ "      \"title\": \"The Bad Guys 2\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.9,\r\n"
	        		+ "      \"vote_count\": 229\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/1RgPyOhN4DRs225BGTlHJqCudII.jpg\",\r\n"
	        		+ "      \"genre_ids\": [16, 28, 14, 53],\r\n"
	        		+ "      \"id\": 1311031,\r\n"
	        		+ "      \"original_language\": \"ja\",\r\n"
	        		+ "      \"original_title\": \"劇場版「鬼滅の刃」無限城編 第一章 猗窩座再来\",\r\n"
	        		+ "      \"overview\": \"The Demon Slayer Corps are drawn into the Infinity Castle, where Tanjiro, Nezuko, and the Hashira face terrifying Upper Rank demons in a desperate fight as the final battle against Muzan Kibutsuji begins.\",\r\n"
	        		+ "      \"popularity\": 301.8484,\r\n"
	        		+ "      \"poster_path\": \"/aFRDH3P7TX61FVGpaLhKr6QiOC1.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-07-18\",\r\n"
	        		+ "      \"title\": \"Demon Slayer: Kimetsu no Yaiba Infinity Castle\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.1,\r\n"
	        		+ "      \"vote_count\": 91\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/kYsU56QEcwEr8jAQ6Vm3M8bXTWz.jpg\",\r\n"
	        		+ "      \"genre_ids\": [28, 35, 18, 37],\r\n"
	        		+ "      \"id\": 1429739,\r\n"
	        		+ "      \"original_language\": \"th\",\r\n"
	        		+ "      \"original_title\": \"เขาชุมทอง คะนองชุมโจร\",\r\n"
	        		+ "      \"overview\": \"At the tail end of World War II, a bandit leader and his crew go up against his sworn enemy and the Japanese army to rob a train full of gold.\",\r\n"
	        		+ "      \"popularity\": 293.5013,\r\n"
	        		+ "      \"poster_path\": \"/7j6jZNhCTnsZy5QItpruDwyBWoo.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-08-19\",\r\n"
	        		+ "      \"title\": \"Gold Rush Gang\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 6.5,\r\n"
	        		+ "      \"vote_count\": 13\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/yth78N88nwokepnOe5atwPGfTL1.jpg\",\r\n"
	        		+ "      \"genre_ids\": [28, 80, 53],\r\n"
	        		+ "      \"id\": 1382406,\r\n"
	        		+ "      \"original_language\": \"zh\",\r\n"
	        		+ "      \"original_title\": \"惊天大营救\",\r\n"
	        		+ "      \"overview\": \"A veteran Muay Thai expert goes on a take-no-prisoners mission of revenge after his wife and daughter are brutally murdered by mysterious forces.\",\r\n"
	        		+ "      \"popularity\": 288.5668,\r\n"
	        		+ "      \"poster_path\": \"/nML8rOI4GOiiEsXgknuhZeUF8M7.jpg\",\r\n"
	        		+ "      \"release_date\": \"2024-12-05\",\r\n"
	        		+ "      \"title\": \"Striking Rescue\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.7,\r\n"
	        		+ "      \"vote_count\": 85\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/lWeaB9S77Os7VHOt8GH5JdfrBX3.jpg\",\r\n"
	        		+ "      \"genre_ids\": [16, 10751, 35, 12, 878],\r\n"
	        		+ "      \"id\": 1022787,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Elio\",\r\n"
	        		+ "      \"overview\": \"Elio, a space fanatic with an active imagination, finds himself on a cosmic misadventure where he must form new bonds with eccentric alien lifeforms, navigate a crisis of intergalactic proportions and somehow discover who he is truly meant to be.\",\r\n"
	        		+ "      \"popularity\": 229.631,\r\n"
	        		+ "      \"poster_path\": \"/w2ARwtc1zoh0pyfwmyhpZHwuXgK.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-06-18\",\r\n"
	        		+ "      \"title\": \"Elio\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7,\r\n"
	        		+ "      \"vote_count\": 332\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/u3Cfe21Cmv5cWs5VnFCz15HdfKO.jpg\",\r\n"
	        		+ "      \"genre_ids\": [27],\r\n"
	        		+ "      \"id\": 1389158,\r\n"
	        		+ "      \"original_language\": \"hi\",\r\n"
	        		+ "      \"original_title\": \"माँ\",\r\n"
	        		+ "      \"overview\": \"A mother and daughter encounter a demon in a village where girls have been disappearing.\",\r\n"
	        		+ "      \"popularity\": 233.6118,\r\n"
	        		+ "      \"poster_path\": \"/kc5n7LJUmvBsVxzAla1ONN8kouP.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-06-20\",\r\n"
	        		+ "      \"title\": \"Maa\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 6.615,\r\n"
	        		+ "      \"vote_count\": 13\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/qEFTuoFIAwrnVn7IsvE8RVt2TK3.jpg\",\r\n"
	        		+ "      \"genre_ids\": [14, 10751, 28, 12],\r\n"
	        		+ "      \"id\": 1087192,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"How to Train Your Dragon\",\r\n"
	        		+ "      \"overview\": \"On the rugged isle of Berk, where Vikings and dragons have been bitter enemies for generations, Hiccup stands apart, defying centuries of tradition when he befriends Toothless, a feared Night Fury dragon. Their unlikely bond reveals the true nature of dragons, challenging the very foundations of Viking society.\",\r\n"
	        		+ "      \"popularity\": 206.9023,\r\n"
	        		+ "      \"poster_path\": \"/q5pXRYTycaeW6dEgsCrd4mYPmxM.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-06-06\",\r\n"
	        		+ "      \"title\": \"How to Train Your Dragon\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 8.024,\r\n"
	        		+ "      \"vote_count\": 1738\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/ySHUoK4utUOiSfCinw81H1TsV0E.jpg\",\r\n"
	        		+ "      \"genre_ids\": [878, 28, 27],\r\n"
	        		+ "      \"id\": 1241470,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Osiris\",\r\n"
	        		+ "      \"overview\": \"Special Forces commandos on a mission are abducted mid-operation by a mysterious spacecraft. Upon waking aboard, they find themselves prey to a relentless alien race in a fight for survival.\",\r\n"
	        		+ "      \"popularity\": 179.8151,\r\n"
	        		+ "      \"poster_path\": \"/3YtZHtXPNG5AleisgEatEfZOT2w.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-07-25\",\r\n"
	        		+ "      \"title\": \"Osiris\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 6.526,\r\n"
	        		+ "      \"vote_count\": 96\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/nZsKWhwhUL3Eg88SkIaJjuIZzpN.jpg\",\r\n"
	        		+ "      \"genre_ids\": [28, 35, 53],\r\n"
	        		+ "      \"id\": 1319895,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Hostile Takeover\",\r\n"
	        		+ "      \"overview\": \"Follows Pete, a professional hitman, as he faces a group of assassins after the boss of a crime syndicate suspects disloyalty due to his attendance at Workaholics Anonymous meetings.\",\r\n"
	        		+ "      \"popularity\": 163.8073,\r\n"
	        		+ "      \"poster_path\": \"/vntwlS3CAKfoLTs90GaoK6lymBC.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-08-08\",\r\n"
	        		+ "      \"title\": \"Hostile Takeover\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.6,\r\n"
	        		+ "      \"vote_count\": 19\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/l3ycQYwWmbz7p8otwbomFDXIEhn.jpg\",\r\n"
	        		+ "      \"genre_ids\": [16, 10402, 28, 14, 35],\r\n"
	        		+ "      \"id\": 803796,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"KPop Demon Hunters\",\r\n"
	        		+ "      \"overview\": \"When K-pop superstars Rumi, Mira and Zoey aren't selling out stadiums, they're using their secret powers to protect their fans from supernatural threats.\",\r\n"
	        		+ "      \"popularity\": 174.701,\r\n"
	        		+ "      \"poster_path\": \"/22AouvwlhlXbe3nrFcjzL24bvWH.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-06-20\",\r\n"
	        		+ "      \"title\": \"KPop Demon Hunters\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 8.4,\r\n"
	        		+ "      \"vote_count\": 1119\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/kyqM6padQzZ1eYxv84i9smNvZAG.jpg\",\r\n"
	        		+ "      \"genre_ids\": [27, 9648],\r\n"
	        		+ "      \"id\": 1078605,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Weapons\",\r\n"
	        		+ "      \"overview\": \"When all but one child from the same class mysteriously vanish on the same night at exactly the same time, a community is left questioning who or what is behind their disappearance.\",\r\n"
	        		+ "      \"popularity\": 173.9557,\r\n"
	        		+ "      \"poster_path\": \"/cpf7vsRZ0MYRQcnLWteD5jK9ymT.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-08-04\",\r\n"
	        		+ "      \"title\": \"Weapons\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.516,\r\n"
	        		+ "      \"vote_count\": 600\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/iZztGzckOMByRRQgsFh2yk3udkU.jpg\",\r\n"
	        		+ "      \"genre_ids\": [28, 27, 10749],\r\n"
	        		+ "      \"id\": 986206,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Night Carnage\",\r\n"
	        		+ "      \"overview\": \"A blogger who is also a werewolf meets a dashing playboy with a dark secret of his own. Starring Logan Andrews and Christian Howard.\",\r\n"
	        		+ "      \"popularity\": 142.0514,\r\n"
	        		+ "      \"poster_path\": \"/w0wjPQKhlqisSbylf1sWZiNyc2h.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-07-29\",\r\n"
	        		+ "      \"title\": \"Night Carnage\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 5.905,\r\n"
	        		+ "      \"vote_count\": 42\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/2VGfjnT3RpjOKADbwgbmXCFSbH.jpg\",\r\n"
	        		+ "      \"genre_ids\": [27, 53],\r\n"
	        		+ "      \"id\": 1443260,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"Rob1n\",\r\n"
	        		+ "      \"overview\": \"When a robotics expert channels the grief of losing his 11 year-old son into building 'Robin', a fully functioning robotic doll, a series of horrific events makes it clear Robin will do whatever it takes to have his creator all to himself.\",\r\n"
	        		+ "      \"popularity\": 131.9568,\r\n"
	        		+ "      \"poster_path\": \"/5lJ2ftNE18iYGCdOQsQirzHHtnX.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-03-20\",\r\n"
	        		+ "      \"title\": \"Rob1n\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 5.197,\r\n"
	        		+ "      \"vote_count\": 33\r\n"
	        		+ "    },\r\n"
	        		+ "    {\r\n"
	        		+ "      \"adult\": false,\r\n"
	        		+ "      \"backdrop_path\": \"/s94NjfKkcSczZ1FembwmQZwsuwY.jpg\",\r\n"
	        		+ "      \"genre_ids\": [878, 12],\r\n"
	        		+ "      \"id\": 617126,\r\n"
	        		+ "      \"original_language\": \"en\",\r\n"
	        		+ "      \"original_title\": \"The Fantastic 4: First Steps\",\r\n"
	        		+ "      \"overview\": \"Against the vibrant backdrop of a 1960s-inspired, retro-futuristic world, Marvel's First Family is forced to balance their roles as heroes with the strength of their family bond, while defending Earth from a ravenous space god called Galactus and his enigmatic Herald, Silver Surfer.\",\r\n"
	        		+ "      \"popularity\": 136.5248,\r\n"
	        		+ "      \"poster_path\": \"/x26MtUlwtWD26d0G0FXcppxCJio.jpg\",\r\n"
	        		+ "      \"release_date\": \"2025-07-23\",\r\n"
	        		+ "      \"title\": \"The Fantastic 4: First Steps\",\r\n"
	        		+ "      \"video\": false,\r\n"
	        		+ "      \"vote_average\": 7.213,\r\n"
	        		+ "      \"vote_count\": 1106\r\n"
	        		+ "    }\r\n"
	        		+ "  ],\r\n"
	        		+ "  \"total_pages\": 52111,\r\n"
	        		+ "  \"total_results\": 1042219\r\n"
	        		+ "}";
	        MovieResponse movres = objectMapper.readValue(json, MovieResponse.class);
	        return movres;
	    }



}
