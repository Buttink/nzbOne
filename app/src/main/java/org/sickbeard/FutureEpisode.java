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


import org.sickbeard.json.FutureEpisodeJson;

public class FutureEpisode {
    
    static public class Builder
    {
        private FutureEpisodeJson json;
        private TimeEnum when;

        public Builder(FutureEpisodeJson json, TimeEnum when) {
            this.when = when;
            this.json = json;
        }

        FutureEpisode Build()
        {
            return new FutureEpisode(json, when);
        }
    }



    private FutureEpisode(FutureEpisodeJson json, TimeEnum when)
    {
        this.AirDate = json.airdate;
        this.Airs = json.airs;
        this.EpisodeName = json.ep_name;
        this.EpisodePlot = json.ep_plot;
        this.Episode = json.episode;
        this.Network = json.network;
        this.Paused = json.paused;
        this.Quality = json.quality;
        this.Season = json.season;
        this.ShowName = json.show_name;
        this.ShowStatus = json.show_status;
        this.TvdbId = json.tvdbid;
        this.DayOfTheWeek = json.weekday;
    }
	
	public enum TimeEnum {
		MISSED, TODAY, SOON, LATER;
	}
	
	public String AirDate;
	public String Airs;
	public String EpisodeName;
	public String EpisodePlot;
	public int Episode;
	public String Network;
	public int Paused;
	public String Quality;
	public int Season;
	public String ShowName;
	public String ShowStatus;
	public int TvdbId;
    /** Day of the Week [1-7] */
	public int DayOfTheWeek;
	public TimeEnum when;
}
