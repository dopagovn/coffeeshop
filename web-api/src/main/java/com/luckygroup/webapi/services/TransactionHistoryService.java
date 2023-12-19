import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckygroup.webapi.models.TransactionHistory;
import com.luckygroup.webapi.repository.TransactionHistoryRepository;

import java.util.List;

@Service
public class TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    public List<TransactionHistory> getAllTransactions() {
        return transactionHistoryRepository.findAll();
    }

    public TransactionHistory getTransactionById(Long id) {
        return transactionHistoryRepository.findById(id).orElse(null);
    }

    public TransactionHistory addTransaction(TransactionHistory transactionHistory) {
        return transactionHistoryRepository.save(transactionHistory);
    }
}
