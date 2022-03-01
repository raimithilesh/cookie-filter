package com.quantcast.cookiefilter.executor;

import com.quantcast.cookiefilter.exception.LogParsingException;
import com.quantcast.cookiefilter.filter.CookieFilter;
import com.quantcast.cookiefilter.parser.CommandInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.quantcast.cookiefilter.executor.ProcessStatus.PROGRAM_FAILED;
import static com.quantcast.cookiefilter.executor.ProcessStatus.SUCCESS;
import static com.quantcast.cookiefilter.parser.LogParser.parseCommandInput;

/**
 * Implementation for the interface ProcessExecutor
 */
public class ProcessExecutorImpl implements ProcessExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessExecutorImpl.class);
    private CookieFilter cookieFilter;

    public ProcessExecutorImpl(CookieFilter cookieFilter) {
        this.cookieFilter = cookieFilter;
    }

    @Override
    public int executeProcess(String[] args) {
        try {
            CommandInput commandInput = parseCommandInput(args);
            cookieFilter.filterMostActiveCookies(commandInput);
            return SUCCESS.getValue();
        } catch (LogParsingException | RuntimeException e) {
            LOGGER.error("Program failed!", e);
        }
        return PROGRAM_FAILED.getValue();
    }
}
