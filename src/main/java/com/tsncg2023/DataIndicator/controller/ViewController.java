package com.tsncg2023.DataIndicator.controller;

import com.tsncg2023.DataIndicator.model.View;
import com.tsncg2023.DataIndicator.Repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/view")
public class ViewController {
    private final ViewRepository viewRepository;

    @Autowired
    public ViewController(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    /**Create View: POST /view with body:
     * { “name”: “...”, “chartType”: “column”, “country”: “IN”,
     * “indicator”: “1.0.HCount.1.90usd", “startDate”:”...”, “endDate”: “...”}
     * Returns http 201 when successful . 4XX if bad data. 5XX if server error
     */
    @PostMapping
    public ResponseEntity<View> createView(@RequestBody View view) {

        if (view.getName() == null || view.getChartType() == null ||
                view.getCountry() == null || view.getIndicator() == null ||
                view.getStartDate() == null || view.getEndDate() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try{
            View savedView = viewRepository.save(view);
            return new ResponseEntity<>(savedView, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**List all Views: GET /view : returns:
     * [{ “viewId”: “v111”, “name”: “...”, “chartType”: “column”, “country”: “IN”,
     * “indicator”: “1.0.HCount.1.90usd", “startDate”:”...”, “endDate”: “...”} ]
     * Returns http 200 when successful . 5XX if server error*/
    @GetMapping
    public ResponseEntity<List<View>> listAllViews() {
        try {
            List<View> views = viewRepository.findAll();
            return new ResponseEntity<>(views, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**Fetch a View by ID: GET /view/<viewId>
     * Returns http 200 when successful . 4XX if bad viewId. 5XX if server error
     */
    @GetMapping("/{viewId}")
    public ResponseEntity<View> getViewById(@PathVariable Long viewId) {
         try{
             Optional<View> view = viewRepository.findById(viewId);
             if (view.isPresent()) {
                 return new ResponseEntity<>(view.get(), HttpStatus.OK);
             }else{
                 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }
         } catch (Exception ex){
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    /**Delete a View: DELETE /view/<viewId>
     * Returns http 200 when successful . 4XX if bad viewId. 5XX if server error
     */
    @DeleteMapping("/{viewId}")
    public ResponseEntity<HttpStatus> deleteView(@PathVariable Long viewId) {
        if (!viewRepository.existsById(viewId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            viewRepository.deleteById(viewId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**Update a View: PUT /view/<viewId> with body:
     * { “viewId”: “v111”, “name”: “...”,“chartType”: “column”,“country”: “IN”,
     * “indicator”: “1.0.HCount.1.90usd", “startDate”:”...”,“endDate”: “...”}
     * Returns http 200 when successful . 4XX if bad viewId or post body. 5XX if server error
     */
    @PutMapping("/{viewId}")
    public ResponseEntity<View> updateView(@PathVariable Long viewId, @RequestBody View updatedView) {

         if (updatedView.getName() == null || updatedView.getChartType() == null ||
                 updatedView.getCountry() == null || updatedView.getIndicator() == null ||
                 updatedView.getStartDate() == null || updatedView.getEndDate() == null) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }

         try {
             Optional<View> existingView = viewRepository.findById(viewId);

             if (existingView.isPresent()) {
                 View updateView = existingView.get();
                 updateView.setName(updatedView.getName());
                 updateView.setChartType(updatedView.getChartType());
                 updateView.setCountry(updatedView.getCountry());
                 updateView.setIndicator(updatedView.getIndicator());
                 updateView.setStartDate(updatedView.getStartDate());
                 updateView.setEndDate(updatedView.getEndDate());

                 View updatedViewEntity = viewRepository.save(updateView);
                 return new ResponseEntity<>(updatedViewEntity, HttpStatus.OK);
             }
             else{
                 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }
         } catch (Exception ex){
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
}