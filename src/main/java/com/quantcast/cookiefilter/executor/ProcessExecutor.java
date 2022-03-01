package com.quantcast.cookiefilter.executor;

/**
 * Interface for handling the process executed in shell command
 */
public interface ProcessExecutor {
    int executeProcess(String[] args);
}
