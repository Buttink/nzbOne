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

import android.text.format.DateFormat;

import com.github.kevinsawicki.wishlist.DatabaseHelper;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.nzbone.util.Ln;

import org.sickbeard.json.HistoryJson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@DatabaseTable(tableName = "tblHistoryItems")
public class HistoryItem {

    public enum HistoryStatus {
        SNATCHED, DOWNLOADED
    }

    private static SimpleDateFormat historyDateFormat = new SimpleDateFormat("yyyy-MM-DD mm:ss", Locale.ENGLISH);

    /**
     * The tvdbid of this show
     */
    @DatabaseField(id = true, columnName = "id")
	public String id;
    @DatabaseField(columnName = "date")
	public Date date;
    @DatabaseField(columnName = "episode")
	public int episode;
    @DatabaseField(columnName = "season")
	public int season;
    @DatabaseField(foreign = true, columnName = "show_id")
	public Show show;
    @DatabaseField(dataType = DataType.ENUM_INTEGER, columnName = "status")
	public HistoryStatus status;
    @DatabaseField(columnName = "provider")
	public String provider;
    @DatabaseField(columnName = "quality")
	public String quality;
    @DatabaseField(columnName = "filename")
	public String filename;
    @DatabaseField(columnName = "nzbname")
	public String nzbname;
	
	public HistoryItem( HistoryJson item )
	{
		this.id = item.tvdbid;
        try {
            this.date = historyDateFormat.parse(item.date);
        } catch (ParseException pe) {
            Ln.e("Failed to parse date.", pe);
        }
		this.episode = item.episode;
		this.season = item.season;
//		this.show = DatabaseHelper.getDao  item.show_name;
//		this.status = item.status;
		if ( item.provider == "-1" ) {
			this.provider = item.provider;
		} else {
			this.provider = "";
		}
		this.quality = item.quality;
		if ( item.status == "Snatch" ) {
			this.nzbname = item.resource;
		} else if ( item.status == "Downloaded" ){
			this.filename = item.resource;
		}
	}
	
	public HistoryItem( HistoryJson download, HistoryJson snatch )
	{
		this.id = download.tvdbid;
//		this.date = download.date;
//		this.episode = String.valueOf(download.episode);
//		this.season = String.valueOf(download.season);
//		this.show = download.show_name;
//		this.status = "Downloaded";
		if ( download.provider == "-1" ) {
			this.provider = snatch.provider;
		} else {
			this.provider = download.provider + " - " + snatch.provider;
		}
		this.quality = download.quality;
		this.filename = download.resource;
		this.nzbname = snatch.resource;
	}
}
