package employeeManager.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {

    private List<Result> results;

}
