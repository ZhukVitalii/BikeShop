package beetle.businessObjects;

import java.util.List;

public class SearchResultBO {
    private List<Object> searchResult;
    private Long totalCount;

    public List<Object> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Object> searchResult) {
        this.searchResult = searchResult;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
