package com.league.league.backendchallenge.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MatrixService {


    /**
     * <p>1.</p>
     * <code>Echo (given)</code>
     *- Return the matrix as a string in matrix format.
     */
    String doMatrixGiven(MultipartFile file) throws IOException;


    /**
     * <p>2.</p>
     * <code>Invert</code>
     *- Return the matrix as a string in matrix format where the columns and rows are inverted
     */
    String doMatrixInverted(MultipartFile file) throws IOException;

    /**
     * <p>3.</p>
     * <code>Flatten</code>
     *- Return the matrix as a 1 line string, with values separated by commas.
     */
    String doMatrixFlatten(MultipartFile file) throws IOException;


    /**
     * <p>4.</p>
     * <code>Sum</code>
     *- Return the sum of the integers in the matrix
     */
    int doMatrixSum(MultipartFile file) throws IOException;


    /**
     * <p>5.</p>
     * <code>Multiply</code>
     *- Return the product of the integers in the matrix
     */
    int doMatrixMultiply(MultipartFile file) throws IOException;


}
