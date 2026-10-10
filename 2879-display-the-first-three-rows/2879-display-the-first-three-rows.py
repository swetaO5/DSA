import pandas as pd

def selectFirstRows(products: pd.DataFrame) -> pd.DataFrame:
    return products.head(3)