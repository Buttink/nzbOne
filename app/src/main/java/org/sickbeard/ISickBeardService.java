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

import org.sickbeard.Episode.StatusEnum;
import org.sickbeard.FutureEpisode.TimeEnum;
import org.sickbeard.Show.QualityEnum;
import org.sickbeard.json.CommandsJson;
import org.sickbeard.json.EpisodeJson;
import org.sickbeard.json.GetQualityJson;
import org.sickbeard.json.HistoryJson;
import org.sickbeard.json.JsonResponse;
import org.sickbeard.json.MessageJson;
import org.sickbeard.json.OptionsJson;
import org.sickbeard.json.PingJson;
import org.sickbeard.json.RootDirJson;
import org.sickbeard.json.SeasonsJson;
import org.sickbeard.json.SeasonsListJson;
import org.sickbeard.json.ShowJson;
import org.sickbeard.json.TvDbResultsJson;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ISickBeardService {

    @GET("/api/{api}/?cmd=episode")
    public JsonResponse<EpisodeJson> Episode(@Path("api") String api, @Query("tvdbid") int tvdbid, @Query("season") int season, @Query("episode") int episode);

    @GET("/api/{api}/?cmd=episode")
    public void Episode(@Path("api") String api, @Query("tvdbid") int tvdbid, @Query("season") int season, @Query("episode") int episode, Callback<JsonResponse<EpisodeJson>> callback);

    @GET("/api/{api}/?cmd=episode")
    public JsonResponse<EpisodeJson> Episode(@Path("api") String api, @Query("tvdbid") int tvdbid, @Query("season") int season, @Query("episode") int episode, @Query("full_path") boolean fullPath);

    @GET("/api/{api}/?cmd=episode")
    public void Episode(@Path("api") String api, @Query("tvdbid") int tvdbid, @Query("season") int season, @Query("episode") int episode, @Query("full_path") boolean fullPath, Callback<JsonResponse<EpisodeJson>> callback);

    @GET("/api/{api}/?cmd=episode.search")
	public JsonResponse<Object> EpisodeSearch(@Path("api") String api, @Query("tvdbid") int tvdbid, @Query("season") int season, @Query("episode") int episode);

    @GET("/api/{api}/?cmd=episode.search")
    public void EpisodeSearch(@Path("api") String api, @Query("tvdbid") int tvdbid, @Query("season") int season, @Query("episode") int episode, Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=episode.setstatus")
	public JsonResponse<Object> EpisodeSetStatus(@Path("api") String api, @Query("tvdbid") int tvdbid, @Query("season") int season, @Query("episode") int episode, @Query("status") StatusEnum status);

    @GET("/api/{api}/?cmd=episode.setstatus")
    public void EpisodeSetStatus(@Path("api") String api, @Query("tvdbid") int tvdbid, @Query("season") int season, @Query("episode") int episode, @Query("status") StatusEnum status, Callback<JsonResponse<Object>> callback);

/*    @GET("/api/{api}/?cmd=episode.setstatus")
	public boolean episodeSetStatus( String tvdbid, List<SeasonEpisodePair> episodes, StatusEnum status ) throws Exception
	{
		StringBuilder builder = new StringBuilder();
		builder.append("episode.setstatus_0");
		for ( int i=1; i < episodes.size(); i++ ) {
			builder.append("|episode.setstatus_");
			builder.append(i);
		}
		builder.append("&tvdbid=");
		builder.append(tvdbid);
		builder.append("&status=");
		builder.append(status.toJson());
		for ( int i=0; i < episodes.size(); i++ ) {
			SeasonEpisodePair p = episodes.get(i);
			builder.append("&episode.setstatus_");
			builder.append(i);
			builder.append(".season=");
			builder.append(p.season);
			builder.append("&episode.setstatus_");
			builder.append(i);
			builder.append(".episode=");
			builder.append(p.episode);
		}
		return this.<Object>commandSuccessful( builder.toString(), new TypeToken<JsonResponse<Object>>(){}.getType() );
	}*/
	
    @GET("/api/{api}/?cmd=episode.exceptions")
	public JsonResponse<ArrayList<String>> Exceptions(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=episode.exceptions")
    public void Exceptions(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<ArrayList<String>>> callback);

    @GET("/api/{api}/?cmd=future")
	public JsonResponse<FutureEpisodes> future(@Path("api") String api, @Query("sort") FutureEpisodes.SortEnum sort);

    @GET("/api/{api}/?cmd=future")
    public void future(@Path("api") String api, @Query("sort") FutureEpisodes.SortEnum sort, Callback<JsonResponse<FutureEpisodes>> callback);

    @GET("/api/{api}/?cmd=history")
	public JsonResponse<HistoryJson> history(@Path("api") String api);

    @GET("/api/{api}/?cmd=history")
    public void history(@Path("api") String api, Callback<JsonResponse<HistoryJson>> callback);

    @GET("/api/{api}/?cmd=history")
    public JsonResponse<HistoryJson> history(@Path("api") String api, @Query("limit") int limit);

    @GET("/api/{api}/?cmd=history")
    public void history(@Path("api") String api, @Query("limit") int limit, Callback<JsonResponse<HistoryJson>> callback);

    @GET("/api/{api}/?cmd=history.clear")
	public JsonResponse<Object> historyClear(@Path("api") String api);

    @GET("/api/{api}/?cmd=history.clear")
    public void historyClear(@Path("api") String api, Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=history.trim")
	public JsonResponse<Object> historyTrim(@Path("api") String api);

    @GET("/api/{api}/?cmd=history.trim")
    public void historyTrim(@Path("api") String api, Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=logs")
	public JsonResponse<Logs> logs(@Path("api") String api);

    @GET("/api/{api}/?cmd=logs")
    public void logs(@Path("api") String api, Callback<JsonResponse<Logs>> callback);

    @GET("/api/{api}/?cmd=logs")
	public JsonResponse<Logs> logs(@Path("api") String api, @Query("min_level") Logs.LevelEnum minLevel);

    @GET("/api/{api}/?cmd=logs")
    public void logs(@Path("api") String api, @Query("min_level") Logs.LevelEnum minLevel, Callback<JsonResponse<Logs>> callback);

    @GET("/api/{api}/?cmd=show")
	public JsonResponse<ShowJson> show(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show")
    public void show(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<ShowJson>> callback);

//	public Show show(String tvdbid, boolean fullSeasonListing) throws Exception
//	{
//		if ( fullSeasonListing ) {
//			StringBuilder builder = new StringBuilder("show|show.seasons");
//			builder.append("&tvdbid=");
//			builder.append(tvdbid);
//
//			ShowWithFullSeasonListing results = this.<ShowWithFullSeasonListing>commandData( builder.toString(), new TypeToken<JsonResponse<ShowWithFullSeasonListing>>(){}.getType() );
//			Show ret = new Show( results.show.data );
//			ret.seasonList.clear();
//			for ( Map.Entry<String, SeasonsJson> season : results.seasons.data.entrySet() ) {
//				ret.seasonList.add( new Season( season.getKey(), season.getValue() ) );
//			}
//			return ret;
//		} else {
//			return show( tvdbid );
//		}
//	}

    @GET("/api/{api}/?cmd=show.addnew")
	public JsonResponse<Object> showAddNew(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.addnew")
    public void showAddNew(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=show.addnew")
    public JsonResponse<Object> showAddNew(@Path("api") String api,
                                           @Query("tvdbid") String tvdbid,
                                           @Query("lang") LanguageEnum language,
                                           @Query("flatten_folders") Boolean seasonFolders,
                                           @Query("status") StatusEnum status,
                                           @Query("initial") EnumSet<QualityEnum> initial,
                                           @Query("archive") EnumSet<QualityEnum> archive);

    @GET("/api/{api}/?cmd=show.addnew")
	public void showAddNew(@Path("api") String api,
                           @Query("tvdbid") String tvdbid,
                           @Query("lang") LanguageEnum language,
                           @Query("flatten_folders") Boolean seasonFolders,
                           @Query("status") StatusEnum status,
                           @Query("initial") EnumSet<QualityEnum> initial,
                           @Query("archive") EnumSet<QualityEnum> archive,
                           Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=show.cache")
	public JsonResponse<CacheStatus> showCache(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.cache")
    public void showCache(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<CacheStatus>> callback);

    @GET("/api/{api}/?cmd=show.delete")
	public JsonResponse<Object> showDelete(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.delete")
    public void showDelete(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=show.getbanner")
	public Response showGetBanner(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.getbanner")
    public void showGetBanner(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<Response> callback);

    @GET("/api/{api}/?cmd=show.getposter")
    public Response showGetPoster(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.getposter")
    public void showGetPoster(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<Response> callback);

    @GET("/api/{api}/?cmd=show.getquality")
	public JsonResponse<GetQualityJson> showGetQuality(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.getquality")
    public void showGetQuality(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<GetQualityJson>> callback);

    @GET("/api/{api}/?cmd=show.pause")
	public JsonResponse<Object> showPause(@Path("api") String api, @Query("tvdbid") String tvdbid, @Query("pause") Boolean pause);

    @GET("/api/{api}/?cmd=show.pause")
    public void showPause(@Path("api") String api, @Query("tvdbid") String tvdbid, @Query("pause") Boolean pause, Callback<JsonResponse<Object>> callback);

//	public boolean showPause(String[] tvdbids, Boolean pause) throws Exception
//	{
//		StringBuilder builder = new StringBuilder();
//		for ( int i=0; i < tvdbids.length; i++ ) {
//			builder.append("show.pause_");
//			builder.append(i);
//			if ( i < tvdbids.length-1 )
//				builder.append("|");
//		}
//		for ( int i=0; i < tvdbids.length; i++ ) {
//			builder.append("&show.pause_");
//			builder.append(i);
//			builder.append(".tvdbid=");
//			builder.append(tvdbids[i]);
//		}
//		if ( pause != null ) {
//			builder.append("&pause=");
//			builder.append( pause ? "1" : "0" );
//		}
//		return this.<Object>commandSuccessful( builder.toString(), new TypeToken<JsonResponse<Object>>(){}.getType() );
//	}

    @GET("/api/{api}/?cmd=show.refresh")
	public JsonResponse<Object> showRefresh(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.refresh")
    public void showRefresh(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<Object>> callback);

//	public boolean showRefresh(String[] tvdbids) throws Exception
//	{
//		StringBuilder builder = new StringBuilder();
//		for ( int i=0; i < tvdbids.length; i++ ) {
//			builder.append("show.refresh_");
//			builder.append(i);
//			if ( i < tvdbids.length-1 )
//				builder.append("|");
//		}
//		for ( int i=0; i < tvdbids.length; i++ ) {
//			builder.append("&show.refresh_");
//			builder.append(i);
//			builder.append(".tvdbid=");
//			builder.append(tvdbids[i]);
//		}
//		return this.<Object>commandSuccessful( builder.toString(), new TypeToken<JsonResponse<Object>>(){}.getType() );
//	}

    @GET("/api/{api}/?cmd=show.seasonlist")
	public JsonResponse<ArrayList<Integer>> showSeasonList(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.seasonlist")
    public void showSeasonList(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<ArrayList<Integer>>> callback);

    @GET("/api/{api}/?cmd=show.seasons")
	public JsonResponse<SeasonsListJson> showSeasons(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.seasons")
    public void showSeasons(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<SeasonsListJson>> callback);

    @GET("/api/{api}/?cmd=show.seasons")
	public JsonResponse<SeasonsJson> showSeasons(@Path("api") String api, @Query("tvdbid") String tvdbid, @Query("season") String season);

    @GET("/api/{api}/?cmd=show.seasons")
    public void showSeasons(@Path("api") String api, @Query("tvdbid") String tvdbid, @Query("season") String season, Callback<SeasonsJson> callback);

    @GET("/api/{api}/?cmd=show.setquality")
	public JsonResponse<Object> showSetQuality(@Path("api") String api,
                                               @Query("tvdbid") String tvdbid,
                                               @Query("initial") EnumSet<QualityEnum> initial,
                                               @Query("archive") EnumSet<QualityEnum> archive);

    @GET("/api/{api}/?cmd=show.setquality")
    public void showSetQuality(@Path("api") String api,
                               @Query("tvdbid") String tvdbid,
                               @Query("initial") EnumSet<QualityEnum> initial,
                               @Query("archive") EnumSet<QualityEnum> archive,
                               Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=show.update")
	public JsonResponse<Object>  showUpdate(@Path("api") String api, @Query("tvdbid") String tvdbid);

    @GET("/api/{api}/?cmd=show.update")
    public void  showUpdate(@Path("api") String api, @Query("tvdbid") String tvdbid, Callback<JsonResponse<Object>> callback);

//	public boolean showUpdate(String[] tvdbids) throws Exception
//	{
//		StringBuilder builder = new StringBuilder();
//		for ( int i=0; i < tvdbids.length; i++ ) {
//			builder.append("show.update_");
//			builder.append(i);
//			if ( i < tvdbids.length-1 )
//				builder.append("|");
//		}
//		for ( int i=0; i < tvdbids.length; i++ ) {
//			builder.append("&show.update_");
//			builder.append(i);
//			builder.append(".tvdbid=");
//			builder.append(tvdbids[i]);
//		}
//		return this.<Object>commandSuccessful( builder.toString(), new TypeToken<JsonResponse<Object>>(){}.getType() );
//	}

    @GET("/api/{api}/?cmd=show.shows")
	public JsonResponse<HashMap<String,ShowJson>> shows(@Path("api") String api);

    @GET("/api/{api}/?cmd=show.shows")
    public void shows(@Path("api") String api, Callback<JsonResponse<HashMap<String,ShowJson>>> callback);

    @GET("/api/{api}/?cmd=sb.forcesearch")
	public JsonResponse<Object> sbForceSearch(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb.forcesearch")
    public void sbForceSearch(@Path("api") String api, Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=sb")
	public JsonResponse<CommandsJson> sbGetCommands(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb")
    public void sbGetCommands(@Path("api") String api, Callback<JsonResponse<CommandsJson>> callback);

    @GET("/api/{api}/?cmd=sb.getdefaults")
	public JsonResponse<OptionsJson> sbGetDefaults(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb.getdefaults")
    public void sbGetDefaults(@Path("api") String api, Callback<JsonResponse<OptionsJson>> callback);

    @GET("/api/{api}/?cmd=sb.getmessages")
	public JsonResponse<ArrayList<MessageJson>> sbGetMessages(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb.getmessages")
    public void sbGetMessages(@Path("api") String api, Callback<JsonResponse<ArrayList<MessageJson>>> callback);

    @GET("/api/{api}/?cmd=sb.getrootdirs")
	public JsonResponse<ArrayList<RootDirJson>> sbGetRootDirs(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb.getrootdirs")
    public void sbGetRootDirs(@Path("api") String api, Callback<JsonResponse<ArrayList<RootDirJson>>> callback);

    @GET("/api/{api}/?cmd=sb.pausebacklog")
	public JsonResponse<Object> sbPauseBackLogSearch(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb.pausebacklog")
    public void sbPauseBackLogSearch(@Path("api") String api, Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=sb.ping")
	public JsonResponse<PingJson> sbPing(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb.ping")
    public void sbPing(@Path("api") String api, Callback<JsonResponse<PingJson>> callback);

    @GET("/api/{api}/?cmd=sb.restart")
	public JsonResponse<Object> sbRestart(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb.restart")
    public void sbRestart(@Path("api") String api, Callback<JsonResponse<Object>> callback);

    @GET("/api/{api}/?cmd=sb.searchtvdb")
	public JsonResponse<TvDbResultsJson> sbSearchTvDb(@Path("api") String api, @Query("name") String query, @Query("lang") LanguageEnum language);

    @GET("/api/{api}/?cmd=sb.searchtvdb")
    public void sbSearchTvDb(@Path("api") String api, @Query("name") String query, @Query("lang") LanguageEnum language, Callback<JsonResponse<TvDbResultsJson>> callback);

//	public boolean sbSetDefaults(OptionsJson defaults) throws Exception
//	{
//		return false;
//	}
	
	// hard to test function XD
    @GET("/api/{api}/?cmd=sb.shutdown")
	public JsonResponse<Object> sbShutdown(@Path("api") String api);

    @GET("/api/{api}/?cmd=sb.shutdown")
    public void sbShutdown(@Path("api") String api, Callback<JsonResponse<Object>> callback);
}
