/*
 * 	libSickBeard is a java library for communication with sickbeard
 * 	Copyright (C) 2012  David Stocking dmstocking@gmail.com
 * 
 * 	http://code.google.com/p/sick-stashe/
 * 	
 * 	libSickBeard is free software: you can redistribute it and/or modify
 * 	it under the terms of the GNU General Public License as published by
 * 	the Free Software Foundation, either version 3 of the License, or
 * 	(at your option) any later version.
 * 	
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 * 	
 * 	You should have received a copy of the GNU General Public License
 * 	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sickbeard;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import org.nzbone.util.QuerySet;
import org.sickbeard.Episode.Status;
import org.sickbeard.Show.Quality;
import org.sickbeard.model.*;
import org.sickbeard.model.ShowJson.CacheStatusJson;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface SickBeardService {

	@GET("episode")
	Observable<JsonResponse<EpisodeJson>>
	episode(@Query("tvdbid") String tvdbId,
			@Query("season") String season,
			@Query("episode") String episode,
			@Query("full_path") int full_path );

	@GET("episode.search")
	Observable<JsonResponse<Object>>
	episodeSearch(@Query("tvdbid") String tvdbId,
				  @Query("season") String season,
				  @Query("episode") String episode);

	@GET("episode.setstatus")
	Observable<Object>
	episodeSetStatus(@Query("tvdbid") String tvdbId,
					 @Query("season") String season,
					 @Query("episode") String episode,
					 @Query("status") Status status);

	@GET("episode.setstatus")
	Observable<JsonResponse<ArrayList<String>>>
	exceptions(@Query("tvdbid") String tvdbId);

	@GET("future")
	Observable<JsonResponse<FutureEpisode>>
	future(@Query("sort") FutureEpisodes.SortEnum sort);

	@GET("history")
	Observable<JsonResponse<History>> history(@Query("limit") int limit);

	@GET("history.clear")
    Observable<JsonResponse<Object>>
	historyClear();

	@GET("history.trim")
	Observable<JsonResponse<Object>>
	historyTrim();

	@GET("logs")
	Observable<JsonResponse<Logs>>
	logs(@Query("min_level") Logs.LevelEnum minLevel);

	@GET("show")
	Observable<JsonResponse<Show>>
	show(@Query("tvdbid") String tvdbId);

	@GET("show.addnew")
	Observable<JsonResponse<Object>>
	showAddNew(@Query("tvdbid") String tvdbId,
			   @Query("lang") Language language,
			   @Query("season_folder") Folder seasonFolders,
			   @Query("status") Status status,
			   @Query("") QuerySet<Quality> initial,
			   @Query("") QuerySet<Quality> archive );

	@GET("show.cache")
	Observable<JsonResponse<CacheStatusJson>>
	showCache(@Query("tvdbid") String tvdbId);

	@GET("show.delete")
	Observable<JsonResponse<Object>> showDelete(@Query("tvdbid") String tvdbId);

	@Streaming
	@GET("show.getbanner")
	Observable<ResponseBody> showGetBanner(@Query("tvdbid") String tvdbId);

	@Streaming
	@GET("show.getposter")
	Observable<ResponseBody> showGetPoster(@Query("tvdbid") String tvdbId);

	@GET("show.getquality")
	Observable<JsonResponse<GetQualityJson>>
	showGetQuality(@Query("tvdbid") String tvdbId);

	@GET("show.pause")
	Observable<JsonResponse<Object>>
	showPause(@Query("tvdbid") String tvdbid);

	@GET("show.pause")
	Observable<JsonResponse<Object>>
	showPause(@Query("tvdbid") String tvdbid, @Query("pause") Pause pause);

	@GET("show.refresh")
	Observable<JsonResponse<Object>>
	showRefresh(@Query("tvdbid") String tvdbid);

    @GET("show.seasonlist")
	Observable<JsonResponse<List<Integer>>>
	showSeasonList(@Query("tvdbid") String tvdbId);

	@GET("show.seasons")
	Observable<JsonResponse<List<Season>>>
	showSeasons(@Query("tvdbid") String tvdbId);

	@GET("show.seasons")
	Observable<JsonResponse<SeasonsJson>>
	showSeasons(@Query("tvdbid") String tvdbId, @Query("season") String season);

	@GET("show.setquality")
	Observable<JsonResponse<Object>>
	showSetQuality(@Query("tvdbid") String tvdbId,
				   @Query("initial") QuerySet<Quality> initial,
				   @Query("archive") QuerySet<Quality> archive);

	@GET("show.update")
	Observable<JsonResponse<Object>> showUpdate(@Query("tvdbid") String tvdbId);

	@GET("shows")
	Observable<JsonResponse<HashMap<String, ShowJson>>> shows();

	@GET("sb.forcesearch")
	Observable<JsonResponse<Object>> sbForceSearch();

	@GET("sb")
	Observable<JsonResponse<CommandsJson>> sbGetCommands();

	@GET("sb.getdefaults")
	Observable<JsonResponse<OptionsJson>> sbGetDefaults();

	@GET("sb.getmessages")
	Observable<JsonResponse<List<MessageJson>>> sbGetMessages();

	@GET("sb.getrootdirs")
	Observable<JsonResponse<List<RootDirJson>>> sbGetRootDirs();

	@GET("sb.pausebacklog")
	Observable<JsonResponse<Object>> sbPauseBackLogSearch();

	@GET("sb.ping")
	Observable<JsonResponse<PingJson>> sbPing();

	@GET("sb.restart")
	Observable<JsonResponse<PingJson>> sbRestart();

	@GET("sb.searchtvdb")
	Observable<JsonResponse<TvDbResultJson>>
	sbSearchTvDb(@Query("name") String name, @Query("lang") Language language);

	@GET("sb.shutdown")
	Observable<JsonResponse<String>> sbShutdown();
}
