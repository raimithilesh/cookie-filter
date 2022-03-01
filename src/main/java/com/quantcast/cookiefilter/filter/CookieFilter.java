package com.quantcast.cookiefilter.filter;

import com.quantcast.cookiefilter.exception.LogParsingException;
import com.quantcast.cookiefilter.parser.CommandInput;

/**
 * Interface for filtering the most active cookies
 */
public interface CookieFilter {
    void filterMostActiveCookies(CommandInput commandInput) throws LogParsingException;
}
