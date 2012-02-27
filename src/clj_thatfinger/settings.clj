(ns clj-thatfinger.settings)

(def ^:dynamic settings
  {:classes   [:ok :offensive]

   :extractor {:type :brazilian-text}

   :database  {:type :mongo
               :mongo  {:host "localhost"
                        :port 27017
                        :database "clj-thatfinger"
                        :auth? false
                        :username ""
                        :password ""}}

   :classifier {:type :default
                :default {:unbiased? false
                          :smoothing-factor 1
                          :threshold? true
                          :thresholds {:ok 1.2
                                       :offensive 2.5}
                          :unknown-class :unknown}}})

(defn update-settings
  "Returns an updated version of map m by applying assoc-in.
Ex: (update-settings settings [:unknown-class] :unknown)"
  [m & kvs]
  (letfn [(f [m [k v]]
            (assoc-in m k v))]
    (reduce f m (partition 2 kvs))))